package com.example.springbootapi.repository;

import com.example.springbootapi.entity.Action;



import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActionRepository extends MongoRepository<Action, String> {

    void deleteById(String _id);

    Optional<Action> findById(String _id);
}