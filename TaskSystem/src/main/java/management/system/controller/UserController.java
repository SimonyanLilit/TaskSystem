package management.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import management.system.common.costants.Constants;
import management.system.common.exceptions.ExceptionResponse;
import management.system.dto.requestdto.UserRequest;
import management.system.dto.responsedto.UserResponse;
import management.system.exception.UserApiException;
import management.system.exception.UserBadRequestException;
import management.system.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(Constants.BASE_URL + Constants.VERSION + "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * Endpoint for creating a user
     *
     * @param userRequest contains the values for the new user (ID must be null)
     * @return the newly-created user
     * @throws UserBadRequestException request validation errors
     * @throws UserApiException        any other user creation error
     */
    @Operation(summary = "Create a user with specified details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request was sent to the endpoint", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ExceptionResponse.class))}),
            @ApiResponse(responseCode = "409", description = "The requested user already exists", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ExceptionResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Error occurred while creating the user",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionResponse.class))})})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody UserResponse createUser(@RequestParam UUID uuid, @RequestBody @Valid UserRequest userRequest) throws UserBadRequestException, UserApiException {
        log.debug("Received a request to create user: {}", userRequest);
        UserResponse user = userService.createUser(userRequest);
        log.debug("Created user: {}", userRequest);
        return user;
    }
}
