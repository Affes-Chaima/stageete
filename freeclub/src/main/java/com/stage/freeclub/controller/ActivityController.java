package com.stage.freeclub.controller;

import com.stage.freeclub.entity.Activity;
import com.stage.freeclub.entity.ActivityType;
import com.stage.freeclub.entity.User;
import com.stage.freeclub.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

    @RestController
    @RequestMapping("/activities")
    public class ActivityController {
        @Autowired
        private ActivityService service;

        @PostMapping("/add")
        public ResponseEntity<Activity> addActivity(@RequestBody Activity activity){
            Activity act=service.addActivity(activity);
            return new ResponseEntity<>(act, HttpStatus.CREATED);
        }
        @PostMapping("/rate/{id}/val={val}")
        public ResponseEntity<Activity> addRating(@PathVariable("val") int rating ,@PathVariable("id") Long id ){
            Activity act=service.addRating(rating,id);
            return new ResponseEntity<>(act, HttpStatus.CREATED);}

        @GetMapping
        public ResponseEntity<List<Activity>> findAllActivities(){

            List<Activity> activities= service.getAllActivities();
            return new ResponseEntity<>(activities, HttpStatus.OK);
        }
        @GetMapping("/{type}_activities")
        public ResponseEntity<List<Activity>> findActivitiesByType(@PathVariable("type") ActivityType type){

            List<Activity> activities= service.getActivitiesByType(type);
            return new ResponseEntity<>(activities, HttpStatus.OK);
        }
        @GetMapping("/{id}")
        public ResponseEntity<Activity> findActivityById(@PathVariable("id")  Long id){
            Activity act=service.getActivityById(id);
            return new ResponseEntity<>(act, HttpStatus.OK);
        }

        @PutMapping("/edit/{id}")
        public ResponseEntity<Activity> updateActivity(@RequestBody Activity activity, @PathVariable("id") Long id ){
            System.out.println("*********************"+activity);
            Activity act =service.updateActivity(activity,id);
            return new ResponseEntity<>(act, HttpStatus.OK);
        }
        /*@PatchMapping("/rate/{id}")
        public ResponseEntity<Activity> updateRating(@RequestBody Activity activity, @PathVariable("id") Long id ){

            Activity act =service.updateRating(activity,id);
            return new ResponseEntity<>(act, HttpStatus.OK);
        }*/

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteActivity(@PathVariable("id") Long id){
            service.deleteActivity(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }
}
