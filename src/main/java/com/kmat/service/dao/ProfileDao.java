package com.kmat.service.dao;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.kmat.service.model.Profile;
import com.kmat.service.model.User;
import com.kmat.service.repository.ProfileRepo;
import com.kmat.service.repository.UserRepo;

@Service
public class ProfileDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileDao.class);

	@Autowired
	ProfileRepo profileRepo;

	@Autowired
	UserRepo repo;

	@Autowired
	MongoTemplate mongoTemplate;

	public Optional<Profile> getProfileById(String id) {

		LOGGER.debug("Id: {}, Profile: {}", id);

		return profileRepo.findById(id);
	}

	public List<Profile> getProfile() {

		LOGGER.debug("Came Inside getProfile");

		return profileRepo.findAll();
	}

	public Profile saveProfile(Profile profile) {

		LOGGER.debug("Came Inside getProfile");

		Profile prof = profileRepo.save(profile);

		updateUser(prof);

		return prof;
	}

	private User updateUser(Profile prof) {

		User usr = mongoTemplate.findById(prof.getProfileId(), User.class);
		usr.setMobile(prof.getMobile());
		usr.setFirstname(prof.getFirstname());
		usr.setLastname(prof.getLastname());

		mongoTemplate.save(usr);

		return usr;
	}


}
