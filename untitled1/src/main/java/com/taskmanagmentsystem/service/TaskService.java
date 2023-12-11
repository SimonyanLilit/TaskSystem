package com.taskmanagmentsystem.service;

import com.taskmanagmentsystem.dto.requestdto.TaskRequestDTO;
import com.taskmanagmentsystem.exceptions.APIException;
import com.taskmanagmentsystem.model.TaskEntity;

import java.util.List;

public interface TaskService {
    TaskEntity add(TaskRequestDTO dto,String name) throws APIException;
    TaskEntity update(TaskRequestDTO dto) throws APIException;
    void delete(Integer id) throws APIException;
    List<TaskEntity> getMyTasks(String name) throws APIException;
    List<TaskEntity> getAllTasks(String name) throws APIException;
}
