package com.example.springbootapi.repository;


import com.example.springbootapi.entity.Sport;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SportRepository extends MongoRepository<Sport, String> {

    void deleteById(String _id);

   
    Optional<Sport> findById(String _id);
}