package com.example.springbootapi.service;

import com.example.springbootapi.entity.Action;
import com.example.springbootapi.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionService {

    private static ActionRepository actionRepository;

    @Autowired
    public  ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public static List<Action> getAllActions() {
        return actionRepository.findAll();
    }

    public static Action getActionById(String _id) {
        Optional<Action> optionalAction = actionRepository.findById(_id);
        return optionalAction.orElseThrow(() -> new RuntimeException("Action not found with id: " + _id));
    }

    public static Action saveAction(Action action) {
        return actionRepository.save(action);
    }

    public static Action updateAction(String _id, Action updateAction) {
        Optional<Action> optionalExistingAction = actionRepository.findById(_id);
        if (optionalExistingAction.isPresent()) {
            Action existingAction = optionalExistingAction.get();
            // Update existingAction with updateAction fields
            existingAction.setName(updateAction.getName());
            existingAction.setRating(updateAction.getRating());
            existingAction.setReview(updateAction.getReview());
            existingAction.setImage(updateAction.getImage());
            existingAction.setStars(updateAction.getStars());
            existingAction.setAverage(updateAction.getAverage());
            existingAction.setHasPlayed(updateAction.isHasPlayed());
            return actionRepository.save(existingAction);
        } else {
            throw new RuntimeException("Action not found with id: " + _id);
        }
    }

    public static void deleteAction(String _id) {
        actionRepository.deleteById(_id);
    }
}