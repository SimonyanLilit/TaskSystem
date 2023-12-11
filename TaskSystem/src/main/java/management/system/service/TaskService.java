package management.system.service;

import management.system.dto.requestdto.TaskRequest;
import management.system.dto.responsedto.TaskResponse;
import management.system.exception.TaskApiException;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    TaskResponse createTask(TaskRequest taskRequest, String email);

    List<TaskResponse> getAll(String title);
    TaskResponse update(UUID id,TaskRequest dto, String name) throws TaskApiException;
    void delete(UUID id,String name) throws TaskApiException;
    TaskResponse changeStatus(UUID id,String status,String name) throws TaskApiException;
    TaskResponse setAssignee(UUID taskId,String userEmail,String name);

}
