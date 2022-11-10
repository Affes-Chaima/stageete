package com.stage.freeclub.repository;

import com.stage.freeclub.entity.Activity;
import com.stage.freeclub.entity.ActivityType;
import com.stage.freeclub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,Long> {

    List<Activity> findByType( ActivityType activityType);

}
