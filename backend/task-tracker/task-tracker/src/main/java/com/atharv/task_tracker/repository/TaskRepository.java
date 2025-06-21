package com.atharv.task_tracker.repository;

import com.atharv.task_tracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
