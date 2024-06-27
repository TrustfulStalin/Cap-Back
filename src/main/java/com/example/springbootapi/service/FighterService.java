package com.example.springbootapi.service;

import com.example.springbootapi.entity.Fighter;
import com.example.springbootapi.repository.FighterRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FighterService {

    private static FighterRepository fighterRepository;

    @Autowired
    public void FighterService(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    public static List<Fighter> getAllFighters() {
        return fighterRepository.findAll();
    }

    public static Fighter getFighterById(String _id) {
        Optional<Fighter> optionalFighter = fighterRepository.findById(_id);
        return optionalFighter.orElseThrow(() -> new RuntimeException("Action not found with id: " + _id));
    }

    public static Fighter saveFighter(Fighter fighter) {
        return fighterRepository.save(fighter);
    }

    public static Fighter updateFighter(String _id, Fighter updateFighter) {
        Optional<Fighter> optionalExistingFighter = fighterRepository.findById(_id);
        if (optionalExistingFighter.isPresent()) {
            Fighter existingFighter = optionalExistingFighter.get();
            // Update existingAction with updateAction fields
            existingFighter.setName(updateFighter.getName());
            existingFighter.setRating(updateFighter.getRating());
            existingFighter.setReview(updateFighter.getReview());
            existingFighter.setImage(updateFighter.getImage());
            existingFighter.setStars(updateFighter.getStars());
            existingFighter.setAverage(updateFighter.getAverage());
            existingFighter.setHasPlayed(updateFighter.isHasPlayed());
            return fighterRepository.save(existingFighter);
        } else {
            throw new RuntimeException("Fighter not found with id: " + _id);
        }
    }

    public static void deleteFighter(String _id) {
        fighterRepository.deleteById(_id);
    }

}