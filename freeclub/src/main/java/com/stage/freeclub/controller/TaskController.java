package com.stage.freeclub.controller;

import com.stage.freeclub.entity.Task;
import com.stage.freeclub.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/activities/tasks")
public class TaskController {
    @Autowired
    private TaskService service;


    @PostMapping("add/activity/{activityId}")
    public ResponseEntity<Task> addTask(@PathVariable (value = "activityId") Long activityId  , @RequestBody Task task){
        Task task1 =service.addTask(activityId, task);
        return new ResponseEntity<>(task1, HttpStatus.CREATED);
    }
    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Task>> getAllTasks(@PathVariable(value="activityId") Long activityId){

        List<Task> tasks = service.getAllTasks(activityId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long id){
        service.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);}

        @PutMapping("/edit/{id}")
        public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable("id") Long id ){
            Task task1 =service.updateTask(task,id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        }

    @GetMapping
    public ResponseEntity<List<Task>> findAllTasks(){

        List<Task> tasks = service.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable("id")  Long id){
        Task task1 =service.getTaskById(id);
        return new ResponseEntity<>(task1, HttpStatus.OK);
    }






    @DeleteMapping("/deletebyactivity/{id}")
    public  ResponseEntity<?> deleteTaskofActivity(@PathVariable("id")Long id){
        service.deleteTasksofActivity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
