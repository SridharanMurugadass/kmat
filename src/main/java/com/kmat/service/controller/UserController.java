package com.kmat.service.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kmat.service.dao.ProfileDao;
import com.kmat.service.model.Profile;
import com.kmat.service.model.User;
import com.kmat.service.repository.UserRepo;
import com.kmat.service.utils.HashingService;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	UserRepo repo;

	@Autowired
	ProfileDao dao;
	
	@Value("${server.url}")
	private String serverUrl;

	@CrossOrigin
	@PostMapping("/signUp")
	public User signUp(@RequestBody User user) {

		LOGGER.debug("email: {}, mobile: {}", user.getEmail(), user.getMobile());

		user.setPassword(HashingService.encodeValue(user.getPassword()));

		Date date = new Date();

		user.setCreatedDate(date);

		User usr = repo.save(user);

		Profile prof = saveProfile(usr);
		
		usr.setProfileId(prof.getProfileId());
		
		System.out.println(prof.getProfileId());

		return usr; // registration success

	}

	private Profile saveProfile(User usr) {

		Profile prof = new Profile();

		prof.setProfileId(usr.getUserId());
		prof.setFirstname(usr.getFirstname());
		prof.setLastname(usr.getLastname());
		prof.setMobile(usr.getMobile());
		prof.setSex(usr.getSex());

		return dao.saveProfile(prof);

	}

	@CrossOrigin
	@PostMapping("/signIn")
	public Optional<Profile> signIn(@RequestBody User user) {

		LOGGER.debug("email: {}, mobile: {}", user.getEmail(), user.getMobile());
		
		user.setPassword(HashingService.encodeValue(user.getPassword()));

		if (!StringUtils.isBlank(user.getEmail())) {

			List<User> data = mongoTemplate.find(Query.query(new Criteria().orOperator((Criteria.where("email")
					.is(user.getEmail()).andOperator(Criteria.where("password").is(user.getPassword()))))), User.class);

			if (!data.isEmpty()) {
				System.out.println("id1 : " + data.get(0).getUserId() + "pass : " +user.getPassword());

				return getValueById(data.get(0).getUserId(), user.getPassword(), user);
			}

			return null; // data not found

		}
		
		List<User> data = mongoTemplate.find(Query.query(new Criteria().orOperator((Criteria.where("mobile")
				.is(user.getMobile())))), User.class);
		
		if (!data.isEmpty()) {

		return getValueById(data.get(0).getUserId(), user.getPassword(), user);
		
		}
		
		return null; // data not found
		
	}

	@CrossOrigin
	@GetMapping("/getUser/{id}")
	public Optional<User> getUserById(@PathVariable String id) {

		Optional<User> data = repo.findById(id);

		data.get().setPassword(null);

		return data;
	}

	@CrossOrigin
	@GetMapping("/emailCheck/{id}")
	public Boolean emailCheck(@PathVariable String id) {

		List<User> data = mongoTemplate.find(Query.query(new Criteria().orOperator((Criteria.where("email").is(id)))),
				User.class);

		if (data.isEmpty()) {

			return false;
		}

		return true;

	}

	@CrossOrigin
	@GetMapping("/mobileCheck/{id}")
	public Boolean mobileCheck(@PathVariable String id) {

		List<User> mobile = mongoTemplate
				.find(Query.query(new Criteria().orOperator((Criteria.where("mobile").is(id)))), User.class);

		if (mobile.isEmpty()) {

			return false;
		}

		return true;

	}

	private Optional<Profile> getValueById(String id, String password, User user) {
		
		System.out.println("id : " + id + "pass : "+password );

		Optional<User> check = repo.findById(id);
		
		if (check.isPresent()) {

			if (check.get().getPassword().equals(password)) {

				return dao.getProfileById(id); // password matches
			}

			return null; // password doesn't matches

		}

		return null; // data not found

	}

	@CrossOrigin
	@GetMapping("/emaiVerify/{id}")
	public Optional<User> emaiVerify(@PathVariable String id) {

		return null;
	}

	@CrossOrigin
	@PostMapping("/saveData")
	public User save(@RequestBody String json) throws ParseException {
		
		System.out.println("serverUrl"+serverUrl);

		JSONParser parser = new JSONParser();
		JSONArray data = (JSONArray) parser.parse(json);
		JSONObject register = (JSONObject) data.get(0);
		JSONObject payment = (JSONObject) data.get(1);

		register.putAll(payment);

		RestTemplate restTemplate = new RestTemplate();
		User usr = restTemplate.postForObject(serverUrl+"/signUp", register, User.class);
		
		

		return usr;
	}

}
