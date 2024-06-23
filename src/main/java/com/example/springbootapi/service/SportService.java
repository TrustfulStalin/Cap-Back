package com.example.springbootapi.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootapi.entity.Sport;
import com.example.springbootapi.repository.SportRepository;

import java.util.List;
import java.util.Optional;


@Service
public class SportService {

    private static SportRepository sportRepository;
    

    @Autowired
    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public static List<Sport> getAllSports() {
        return sportRepository.findAll();
    }

    public static Sport getSportById(String _id) {
        Optional<Sport> optionalSport = sportRepository.findById(_id);
        return optionalSport.orElseThrow(() -> new RuntimeException("Sports not found with id: " + _id));
    }

    public static Sport savesSport(Sport sport) {
        return sportRepository.save(sport);
    }

    public static Sport updateSport(String _id, Sport updateSport) {
        Optional<Sport> optionalExistingsport = sportRepository.findById(_id);
        if (optionalExistingsport.isPresent()) {
            Sport existingSport = optionalExistingsport.get();
            // Update existingAction with updateAction fields
            existingSport.setName(updateSport.getName());
            existingSport.setRating(updateSport.getRating());
            existingSport.setReview(updateSport.getReview());
            existingSport.setImage(updateSport.getImage());
            existingSport.setStars(updateSport.getStars());
            existingSport.setAverage(updateSport.getAverage());
            existingSport.setHasPlayed(updateSport.isHasPlayed());
            return sportRepository.save(existingSport);
        } else {
            throw new RuntimeException("Sports not found with id: " + _id);
        }
    }

    public static void deleteSport(String _id) {
        sportRepository.deleteById(_id);
    }

    public static  Sport saveSport(Sport sport) {
        return sportRepository.save(sport);
        
    }
}