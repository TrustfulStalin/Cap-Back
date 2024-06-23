package com.example.springbootapi;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootapi.entity.Action;
import com.example.springbootapi.service.ActionService;

@SpringBootApplication
@RestController
@EnableMongoRepositories(basePackages = "com.example.springbootapi.repository")
public class GameSphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameSphereApplication.class, args);
    }


    @Autowired
    private ActionService actionService;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

        @GetMapping("/actions")
    public List<Action> getAllActions() {
        return actionService.getAllActions();
    }

    @GetMapping("/actions/{id}")
    public ResponseEntity<Action> getActionById(@PathVariable String id) {
        Action action = actionService.getActionById(id);
        return ResponseEntity.ok(action);
    }

    @PostMapping("/actions")
    public ResponseEntity<Action> saveAction(@RequestBody Action action) {
        Action savedAction = actionService.saveAction(action);
        return ResponseEntity.ok(savedAction);
    }

    @PutMapping("/actions/{id}")
    public ResponseEntity<Action> updateAction(@PathVariable String id, @RequestBody Action action) {
        Action updatedAction = actionService.updateAction(id, action);
        return ResponseEntity.ok(updatedAction);
    }

    @DeleteMapping("/actions/{id}")
    public ResponseEntity<Void> deleteAction(@PathVariable String id) {
        actionService.deleteAction(id);
        return ResponseEntity.noContent().build();
    }
}





