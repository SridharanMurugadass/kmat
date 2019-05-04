package com.kmat.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.kmat.service.model.User;

public interface UserRepo extends MongoRepository<User, String> {


}
