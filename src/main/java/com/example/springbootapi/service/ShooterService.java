package com.example.springbootapi.service;

import com.example.springbootapi.entity.Action;
import com.example.springbootapi.entity.Shooter;
import com.example.springbootapi.repository.ActionRepository;
import com.example.springbootapi.repository.ShooterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ShooterService {

    private static ShooterRepository shooterRepository;
    

    @Autowired
    public ShooterService(ShooterRepository shooterRepository) {
        this.shooterRepository = shooterRepository;
    }

    public static List<Shooter> getAllShooters() {
        return shooterRepository.findAll();
    }

    public static Shooter getShooterById(String _id) {
        Optional<Shooter> optionalShooter = shooterRepository.findById(_id);
        return optionalShooter.orElseThrow(() -> new RuntimeException("Shooter not found with id: " + _id));
    }

    public static Shooter saveShooter(Shooter shooter) {
        return shooterRepository.save(shooter);
    }

    public static Shooter updateShooter(String _id, Shooter updateShooter) {
        Optional<Shooter> optionalExistingshooter = shooterRepository.findById(_id);
        if (optionalExistingshooter.isPresent()) {
            Shooter existingShooter = optionalExistingshooter.get();
            // Update existingAction with updateAction fields
            existingShooter.setName(updateShooter.getName());
            existingShooter.setRating(updateShooter.getRating());
            existingShooter.setReview(updateShooter.getReview());
            existingShooter.setImage(updateShooter.getImage());
            existingShooter.setStars(updateShooter.getStars());
            existingShooter.setAverage(updateShooter.getAverage());
            existingShooter.setHasPlayed(updateShooter.isHasPlayed());
            return shooterRepository.save(existingShooter);
        } else {
            throw new RuntimeException("Action not found with id: " + _id);
        }
    }

    public static void deleteShooter(String _id) {
        shooterRepository.deleteById(_id);
    }
}