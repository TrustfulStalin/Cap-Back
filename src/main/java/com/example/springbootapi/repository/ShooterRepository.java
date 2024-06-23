package com.example.springbootapi.repository;


import com.example.springbootapi.entity.Shooter;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShooterRepository extends MongoRepository<Shooter, String> {

    void deleteById(String _id);

   
    Optional<Shooter> findById(String _id);
}