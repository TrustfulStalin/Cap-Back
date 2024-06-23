package com.example.springbootapi;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

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
import com.example.springbootapi.entity.Fighter;
import com.example.springbootapi.entity.Shooter;
import com.example.springbootapi.entity.Sport;
import com.example.springbootapi.service.ActionService;
import com.example.springbootapi.service.FighterService;
import com.example.springbootapi.service.ShooterService;
import com.example.springbootapi.service.SportService;

@SpringBootApplication
@RestController
@EnableMongoRepositories(basePackages = "com.example.springbootapi.repository")
public class GameSphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameSphereApplication.class, args);
    }


   
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

    @GetMapping("/shooter")
    public List<Shooter> getAllshooters() {
        return ShooterService.getAllShooters();
    }

    @GetMapping("/shooter/{id}")
    public ResponseEntity<Shooter> getShooterById(@PathVariable String id) {
        Shooter shooter = ShooterService.getShooterById(id);
        return ResponseEntity.ok(shooter);
    }

    @PostMapping("/shooters")
    public ResponseEntity<Shooter> saveShooter(@RequestBody Shooter shooter) {
        Shooter savedShooter = ShooterService.saveShooter(shooter);
        return ResponseEntity.ok(savedShooter);
    }

    @PutMapping("/shooter/{id}")
    public ResponseEntity<Shooter> updateShooter(@PathVariable String id, @RequestBody Shooter shooter) {
        Shooter updatedShooter = ShooterService.updateShooter(id, shooter);
        return ResponseEntity.ok(updatedShooter);
    }

    @DeleteMapping("/shooters/{id}")
    public ResponseEntity<Void> deleteShooter(@PathVariable String id) {
        ShooterService.deleteShooter(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/fighter")
    public List<Fighter> getAllfighters() {
        return FighterService.getAllFighters();
    }

    @GetMapping("/fighter/{id}")
    public ResponseEntity<Fighter> getFighterById(@PathVariable String id) {
        Fighter fighter = FighterService.getFighterById(id);
        return ResponseEntity.ok(fighter);
    }

    @PostMapping("/fighters")
    public ResponseEntity<Fighter> saveFighter(@RequestBody Fighter fighter) {
        Fighter savedFighter = FighterService.saveFighter(fighter);
        return ResponseEntity.ok(savedFighter);
    }

    @PutMapping("/fighter/{id}")
    public ResponseEntity<Fighter> updateFighter(@PathVariable String id, @RequestBody Fighter fighter) {
        Fighter updatedFighter = FighterService.updateFighter(id, fighter);
        return ResponseEntity.ok(updatedFighter);
    }

    @DeleteMapping("/fighters/{id}")
    public ResponseEntity<Void> deleteFighter(@PathVariable String id) {
        FighterService.deleteFighter(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/sport")
    public List<Sport> getAllSports() {
        return SportService.getAllSports();
    }

    @GetMapping("/sport/{id}")
    public ResponseEntity<Sport> getSportById(@PathVariable String id) {
        Sport sport = SportService.getSportById(id);
        return ResponseEntity.ok(sport);
    }

    @PostMapping("/sports")
    public ResponseEntity<Sport> saveSport(@RequestBody Sport sport) {
        Sport savedSport = SportService.saveSport(sport);
        return ResponseEntity.ok(savedSport);
    }

    @PutMapping("/sport/{id}")
    public ResponseEntity<Sport> updateSport(@PathVariable String id, @RequestBody Sport sport) {
        Sport updatedSport = SportService.updateSport(id, sport);
        return ResponseEntity.ok(updatedSport);
    }

    @DeleteMapping("/sport/{id}")
    public ResponseEntity<Void> deleteSport(@PathVariable String id) {
        SportService.deleteSport(id);
        return ResponseEntity.noContent().build();
    }



    
}





