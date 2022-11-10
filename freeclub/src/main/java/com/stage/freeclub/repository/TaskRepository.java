package com.stage.freeclub.repository;

import com.stage.freeclub.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    //Page<Task> findByActivityId(Long activityId, Pageable pageable);
    List<Task> findByActivityId(Long activityId);
    @Transactional
    void deleteByActivityId(long activityId);
}

