package com.kmat.service.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kmat.service.model.ImageStore;
import com.kmat.service.repository.ImageRepo;

@RestController
public class FileController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private ImageRepo imageRepo;

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	ServletContext servletContext;

	@CrossOrigin
	@PostMapping(path = "/saveFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ImageStore saveFile(@RequestParam("file") MultipartFile file, @RequestParam("profileId") String profileId)
			throws IOException {

		System.out.println("profileId :" + profileId);

		ImageStore store = new ImageStore();

		store.setProfileId(profileId);
		store.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));

		return imageRepo.save(store);

	}

	@CrossOrigin
	@PutMapping(path = "/updateFile/{imageId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ImageStore updateFile(@RequestParam("file") MultipartFile file, @PathVariable("imageId") String imageId)
			throws IOException {

		System.out.println("imageId :" + imageId);

		ImageStore store = mongoTemplate.findById(imageId, ImageStore.class);

		store.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));

		return mongoTemplate.save(store);

	}

	@CrossOrigin
	@GetMapping("/getImages/{profileId}")
	public List<ImageStore> getImages(@PathVariable("profileId") String profileId) {

		List<ImageStore> data = mongoTemplate.find(
				Query.query(new Criteria().orOperator((Criteria.where("profileId").is(profileId)))), ImageStore.class);

		return data;
	}

	@CrossOrigin
	@GetMapping("/getImage/{imageId}")
	public ImageStore getImage(@PathVariable("imageId") String imageId) {

		return mongoTemplate.findById(imageId, ImageStore.class);
	}

	@CrossOrigin
	@DeleteMapping("/deleteImage/{imageId}")
	public boolean deleteImage(@PathVariable("imageId") String imageId) {

		imageRepo.deleteById(imageId);

		return true;
	}

}