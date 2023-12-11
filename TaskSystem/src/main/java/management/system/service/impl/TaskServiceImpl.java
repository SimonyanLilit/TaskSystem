package management.system.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import management.system.dto.requestdto.TaskRequest;
import management.system.dto.responsedto.TaskResponse;
import management.system.enums.Status;
import management.system.exception.*;
import management.system.model.TaskEntity;
import management.system.model.UserEntity;
import management.system.repository.TaskRepository;
import management.system.repository.UserRepository;
import management.system.service.TaskService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskResponse createTask(TaskRequest taskRequest, String email) {
        TaskEntity task = null;
        try {
            UserEntity user = userRepository.getByEmail(email);
            TaskEntity entity = new TaskEntity();
            entity.setTitle(taskRequest.getTitle());
            entity.setDescription(taskRequest.getDescription());
            entity.setStatus(taskRequest.getStatus());
            entity.setPriority(taskRequest.getPriority());
            entity.setAuthor(user);
            task = taskRepository.save(entity);
        } catch (Exception e) {
            throw new TaskApiException("Error occurred while creating task");
        }
        return new ObjectMapper().convertValue(task, TaskResponse.class);
    }

    @Override
    public List<TaskResponse> getAll(String title) {
        List<TaskEntity> taskEntities = new ArrayList<>();
        try {
            if (!StringUtils.isEmpty(title)) {
                taskEntities = taskRepository.getByTitle(title);
            } else {
                taskEntities = taskRepository.findAll();
            }
        } catch (Exception e) {
            throw new TaskApiException("Error occurred while getting tasks");
        }
        return new ObjectMapper().convertValue(taskEntities, new TypeReference<List<TaskResponse>>() {
        });
    }

    @Override
    public TaskResponse update(UUID id,TaskRequest dto, String name) throws TaskApiException {
        UserEntity userEntity = userRepository.getByEmail(name);

        TaskEntity taskEntity=null;
        try {
            taskEntity=taskRepository.getReferenceById(id);
        }catch (Exception e){
            throw new TaskApiException("problem during updating task");
        }
        if (taskEntity.getAuthor()!=userEntity)
            throw new UserForbiddenException("you have no permission to update task");
        taskEntity.setTitle(dto.getTitle()==null? taskEntity.getTitle() : dto.getTitle());
        taskEntity.setDescription(dto.getDescription()==null? taskEntity.getDescription() : dto.getDescription());
        taskEntity.setPriority(dto.getPriority()==null? taskEntity.getPriority(): dto.getPriority());
        try {
            taskRepository.save(taskEntity);
        }catch (Exception e){
            throw new TaskApiException("problem during updating task");
        }


        return new ObjectMapper().convertValue(taskEntity,TaskResponse.class);
    }

    @Override
    public void delete(UUID id, String name) throws TaskApiException {
        Optional<TaskEntity> taskEntity=null;
        try {

            taskEntity = taskRepository.findById(id);
            if (!taskEntity.isPresent())
                throw new TaskNotFoundException("task not found with given id");
            UserEntity userEntity = userRepository.getByEmail(name);
            if (taskEntity.get().getAuthor()!=userEntity)
                throw new UserForbiddenException("you have no permission to update task");
            taskRepository.deleteById(id);
        }catch (Exception e){

            throw new TaskApiException("problem during deleting task");
        }
    }

    @Override
    public TaskResponse changeStatus(UUID id, String status, String name) throws TaskApiException {
        TaskEntity taskEntity=null;
        UserEntity user=userRepository.getByEmail(name);

        try{
            taskEntity= taskRepository.getById(id);
            if(taskEntity==null)
                throw new TaskNotFoundException("task is not found with given id");
        }catch (Exception e){
            throw new TaskApiException("problem during getting task");
        }
        if(!taskEntity.getAuthor().equals(user)&&!taskEntity.getAssignee().equals(user))
            throw new UserForbiddenException("you have no permission to change status");
        taskEntity.setStatus(Status.valueOf(status));
        taskRepository.save(taskEntity);
        return new ObjectMapper().convertValue(taskEntity,TaskResponse.class);

    }

    @Override
    public TaskResponse setAssignee(UUID taskId, String assigneeEmail, String name) {
        TaskEntity taskEntity=null;
        UserEntity user=userRepository.getByEmail(name);

        try{
            taskEntity= taskRepository.getById(taskId);
            if(taskEntity==null)
                throw new TaskNotFoundException("task is not found with given id");
        }catch (Exception e){
            throw new TaskApiException("problem during getting task");
    }
        if (user!=taskEntity.getAuthor())
            throw new UserForbiddenException("you have no permission to set assignee");
        UserEntity assignee=null;
          assignee=userRepository.getByEmail(assigneeEmail);
          if(assignee==null)
              throw new UserNotFoundException("user not found with given email");
            taskEntity.setAssignee(assignee);
            try {
                taskRepository.save(taskEntity);
            }catch (Exception e){
                throw new TaskApiException("problem during saving changes");
            }

        return new ObjectMapper().convertValue(taskEntity,TaskResponse.class);
        }



}
