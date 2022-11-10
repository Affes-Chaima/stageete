package com.stage.freeclub.service;

import com.stage.freeclub.entity.Task;
import com.stage.freeclub.entity.User;
import com.stage.freeclub.exception.ResourceNotFoundException;
import com.stage.freeclub.repository.ActivityRepository;
import com.stage.freeclub.repository.AuthRepository;
import com.stage.freeclub.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repo;
    @Autowired
    private ActivityRepository repo1;
    @Autowired
    private AuthService authservice;




    public Task addTask(Long activityId, Task task){
        Task task1 = repo1.findById(activityId).map(activity -> {
            task.setActivity(activity);
            return task;}).orElseThrow(()-> new ResourceNotFoundException("element not found"));
        User user1= authservice.getUserById(task1.getUserId());
        task1.setAssignedTo(user1.getUsername());
        System.out.println( user1.getUsername()+ task1.getAssignedTo());
            return repo.save(task);
           }
    public List<Task> getAllTasks(){
        return repo.findAll();}


    public List<Task> getAllTasks(Long activityId){
        if (!repo1.existsById(activityId)) {
            throw new ResourceNotFoundException("Not found Tutorial with id = " + activityId);
        }
        System.out.println("done***");
        return repo.findByActivityId(activityId);
    }

    public Task getTaskById(Long id){return repo.findById(id).orElse(null);}
    public void deleteTask(Long id){repo.deleteById(id);}
    public void deleteTasksofActivity(Long activityId){
        if (!repo1.existsById(activityId)) {
            throw new ResourceNotFoundException("Not found Tutorial with id = " + activityId);
        }
        repo.deleteByActivityId(activityId);}
    public Task updateTask(Task task, Long id){
        Task task1 =getTaskById(id);
        User user1= authservice.getUserById(task1.getUserId());
        task1.setTitle(task.getTitle());
        task1.setStart(task.getStart());
        task1.setEnd(task.getEnd());
        task1.setAssignedTo(user1.getUsername());
        System.out.println( user1.getUsername()+ task1.getAssignedTo());


        return repo.save(task1);
    }

}
