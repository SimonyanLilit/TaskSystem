package com.taskmanagmentsystem.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taskmanagmentsystem.dto.requestdto.TaskRequestDTO;
import com.taskmanagmentsystem.enums.Role;
import com.taskmanagmentsystem.enums.Status;
import com.taskmanagmentsystem.exceptions.APIException;
import com.taskmanagmentsystem.exceptions.userexceptions.UserNotFoundException;
import com.taskmanagmentsystem.exceptions.userexceptions.UserValidationException;
import com.taskmanagmentsystem.model.TaskEntity;
import com.taskmanagmentsystem.model.UserEntity;
import com.taskmanagmentsystem.repository.TaskRepository;
import com.taskmanagmentsystem.repository.UserRepository;
import com.taskmanagmentsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public TaskEntity add(TaskRequestDTO dto,String name) throws APIException {
        TaskEntity taskEntity=new TaskEntity();
        List<UserEntity> userEntityList = userRepository.getByEmail(name);
        UserEntity userEntity = userEntityList.get(0);
        if(userEntity.getRole()!= Role.AUTHOR)
            throw new UserValidationException("you have no permission to add task");
        taskEntity.setAuthorEntity(userEntity);
        taskEntity.setId(0);
        taskEntity.setTitle(dto.getRequestTitle());
        taskEntity.setDescription(dto.getRequestDescription());
        taskEntity.setStatus(Status.PENDING);
        taskEntity.setPriority(dto.getRequestPriority());
        List<UserEntity> executors=null;
        try{
            executors=userRepository.getByEmail(dto.getRequestExecutorEmail());
        }catch(Exception e){
            throw new APIException("problem during getting executor data");
        }
        if(executors.isEmpty())
        throw new UserNotFoundException("user not found with given email");
        taskEntity.setExecutorEntity(executors.get(0));

        try{
            taskRepository.save(taskEntity);

        }catch (Exception e){
            throw new APIException("problem during saving task.");
        }
        return taskEntity;
    }

    @Override
    public TaskEntity update(TaskRequestDTO dto) throws APIException {
       TaskEntity taskEntity=null;
        try {
            taskEntity=taskRepository.getById(dto.getId());
        }catch (Exception e){
            throw new APIException("problem during updating task");
        }
        taskEntity.setTitle(dto.getRequestTitle()==null? taskEntity.getTitle() : dto.getRequestTitle());
        taskEntity.setDescription(dto.getRequestDescription()==null? taskEntity.getDescription() : dto.getRequestDescription());
        taskEntity.setStatus(dto.getRequestStatus()==null? taskEntity.getStatus() : dto.getRequestStatus());
        taskEntity.setPriority(dto.getRequestPriority()==null? taskEntity.getPriority() : dto.getRequestPriority());
        List<UserEntity> executors = userRepository.getByEmail(dto.getRequestExecutorEmail());
        taskEntity.setExecutorEntity(dto.getRequestExecutorEmail()==null? taskEntity.getExecutorEntity() : executors.get(0));
        try {
            taskRepository.save(taskEntity);
        }catch (Exception e){
            throw new APIException("problem during updating restaurant");
        }
        return taskEntity;
    }

    @Override
    public void delete(Integer id) throws APIException {
        Optional<TaskEntity> taskEntity=null;
        try {

            taskEntity= taskRepository.findById(id);
            if (!taskEntity.isPresent())
                throw new APIException("task not found with given id");
            taskRepository.deleteById(id);
        }catch (Exception e){
            throw new APIException("problem during deleting task");
        }

    }

    @Override
    public List<TaskEntity> getMyTasks(String name) throws APIException {
        List<TaskEntity> taskEntities=null;
        UserEntity userEntity = userRepository.getByEmail(name).get(0);
        try {

                taskEntities=taskRepository.getAllByAuthorEntity(userEntity);

        }catch (Exception e){
            throw new APIException("problem during getting tasks");
        }

        return taskEntities ;

    }

    @Override
    public List<TaskEntity> getAllTasks(String name) throws APIException {
        List<TaskEntity> taskEntities=null;
        UserEntity userEntity = userRepository.getByEmail(name).get(0);
        if(userEntity.getRole()!=Role.AUTHOR)
            throw new UserValidationException("you have no permission to get all tasks");
        try {
            taskEntities=taskRepository.getAllBy();
        }catch (Exception e){
            throw new APIException("problem during getting tasks");
        }

        return taskEntities ;

    }

}
