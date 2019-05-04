package com.kmat.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kmat.service.model.ImageStore;

public interface ImageRepo extends MongoRepository<ImageStore, String> {

}
