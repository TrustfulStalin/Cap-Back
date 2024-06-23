package com.example.springbootapi.repository;


import com.example.springbootapi.entity.Fighter;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FighterRepository extends MongoRepository<Fighter, String> {

    void deleteById(String _id);

   
    Optional<Fighter> findById(String _id);
}