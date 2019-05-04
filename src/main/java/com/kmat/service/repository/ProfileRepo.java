package com.kmat.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.kmat.service.model.Profile;

public interface ProfileRepo extends MongoRepository<Profile, String> {

}
