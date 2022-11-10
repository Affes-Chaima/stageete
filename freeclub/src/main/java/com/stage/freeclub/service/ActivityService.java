package com.stage.freeclub.service;

import com.stage.freeclub.entity.Activity;
import com.stage.freeclub.entity.ActivityType;
import com.stage.freeclub.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository repo;

        public Activity addActivity(Activity activity){
        return repo.save(activity);
    }


    public List<Activity> getAllActivities(){return repo.findAll();}
    public List<Activity> getActivitiesByType(ActivityType type){
        return repo.findByType(type);}
    public Activity getActivityById(Long id){return repo.findById(id).orElse(null);}
    public void deleteActivity(Long id){repo.deleteById(id);}
    public Activity updateActivity(Activity activity, Long id){
            System.out.println("value"+activity);
        Activity act =getActivityById(id);
        System.out.println("act="+act);
        act.setName(activity.getName());
        act.setType(activity.getType());
        act.setPlace(activity.getPlace());
        act.setCost(activity.getCost());
        act.setDate_begin(activity.getDate_begin());
        act.setDate_end(activity.getDate_end());
        System.out.println(activity.getRating());
        act.setRating(activity.getRating());
        System.out.println(act.getRating());
        return repo.save(act);
    }
    public Activity addRating(int rating, Long id){
        Activity act=getActivityById(id);
        act.setRating(rating);
        return repo.save(act);
    }


    /*public Activity updateRating(Activity activity, Long id){
            System.out.println(activity);
        System.out.println(id);
        Activity act =getActivityById(id);
        System.out.println(act);
        act.setRating(activity.getRating());
        System.out.println("done"+act+activity);
        return repo.save(act);
    }*/


}
