package com.taskmanagmentsystem.repository;

import com.taskmanagmentsystem.model.TaskEntity;

import com.taskmanagmentsystem.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
    List<TaskEntity> getAllByAuthorEntity(UserEntity authorEntity);
    TaskEntity getById(Integer id);
    List<TaskEntity> getAllBy();

}
