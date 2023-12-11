package management.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import management.system.common.costants.Constants;
import management.system.common.exceptions.ExceptionResponse;
import management.system.dto.requestdto.TaskRequest;
import management.system.dto.responsedto.TaskResponse;
import management.system.exception.UserApiException;
import management.system.exception.UserBadRequestException;
import management.system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(Constants.BASE_URL + Constants.VERSION + "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    /**
     * Endpoint for creating a task
     *
     * @param taskRequest contains the values for the new task (ID must be null)
     * @return the newly-created task
     * @throws UserBadRequestException request validation errors
     * @throws UserApiException        any other task creation error
     */
    @Operation(summary = "Create a task with specified details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "task created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TaskResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request was sent to the endpoint", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ExceptionResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Error occurred while creating the task",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionResponse.class))})})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody TaskResponse createTask(@RequestBody TaskRequest taskRequest, Principal principal) {
        log.debug("Received a request to create task: {}", taskRequest);
        TaskResponse task = taskService.createTask(taskRequest, principal.getName());
        log.debug("Created task: {}", taskRequest);
        return task;
    }

    /**
     * Endpoint for getting list of tasks
     * @return the list of tasks
     */
    @Operation(summary = "Get list of all tasks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The list of all tasks was received",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TaskResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Error occurred while getting the task",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionResponse.class))})})
    @GetMapping
    public @ResponseBody List<TaskResponse> getAll(@RequestParam (required = false) String title) {
        log.debug("Received a request to get the list of all tenants");
        List<TaskResponse> taskResponses = taskService.getAll(title);
        log.debug("Got the list of tasks");
        return taskResponses;
        /**
         Endpoint for updating a task
         * @param UUID   id of updating task
         * @param taskRequest contains the values for the updating task (ID must be null)
         * @return the updated task
         * @throws UserBadRequestException request validation errors
         * @throws UserApiException        any other task updating error
         **/
    }
@PutMapping
    public @ResponseBody TaskResponse update(@RequestParam UUID id,@RequestBody TaskRequest taskRequest,Principal principal){
    log.debug("Received a request to update task: {}", taskRequest);
    TaskResponse task = taskService.update(id,taskRequest, principal.getName());
    log.debug("Updated task: {}", taskRequest);
    return task;
}
    /** Endpoint for deleting a task
     * {id @pathvariable} UUID  of task for deletion
     * @throws UserApiException        any other task updating error
     * **/
    @DeleteMapping
    public @ResponseBody ResponseEntity<Void> delete(@PathVariable UUID id, Principal principal){
        log.debug("Received a request to delete task:");
        taskService.delete(id, principal.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /** /** Endpoint for opdate status of a task
     * @param id UUID  of task for deletion
     * @param status String  of task for deletion
     * @return the updated task
     *
     * @throws UserApiException  any other task updating error
     * **/

@PatchMapping
    public @ResponseBody TaskResponse changeStatus(@RequestParam UUID id, @RequestParam String status, Principal principal){
    log.debug("Received a request to update task status: ");
    TaskResponse task = taskService.changeStatus(id,status, principal.getName());
    log.debug("Updated status: " );
    return task;
}   /** /** Endpoint for setting assignee of a task
     * @param taskId UUID  of task
     * @param userEmail String  email of assignee
     * @return the updated task
     *
     * @throws UserApiException  any other task updating error
     * **/

    @PatchMapping
    public @ResponseBody TaskResponse setAssignee(@RequestParam UUID taskId,@RequestParam String userEmail,Principal principal){
        log.debug("Received a request to update task status: ");
        TaskResponse task = taskService.setAssignee(taskId,userEmail, principal.getName());
        log.debug("Setting assignee: " );
        return task;
    }
}
