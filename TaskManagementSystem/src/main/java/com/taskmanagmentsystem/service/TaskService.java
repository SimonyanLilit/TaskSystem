package com.taskmanagmentsystem.service;

import com.taskmanagmentsystem.dto.requestdto.TaskRequestDTO;
import com.taskmanagmentsystem.exceptions.APIException;
import com.taskmanagmentsystem.model.TaskEntity;

import java.util.List;

public interface TaskService {

    TaskEntity add(TaskRequestDTO dto,String name) throws APIException;

}
