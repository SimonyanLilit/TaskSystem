package com.taskmanagmentsystem.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class TaskManagementSystemExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(TaskManagementValidationException.class)
    public ResponseEntity<ErrorResponse> bookingValidationExceptionHandler(TaskManagementValidationException exception){
        ErrorResponse errorResponse=new ErrorResponse(exception.getMessage(),HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @ExceptionHandler(APIException.class)
    public ResponseEntity<ErrorResponse> apiExceptionHandler(APIException exception){
        ErrorResponse errorResponse=new ErrorResponse(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
    @ExceptionHandler(TaskManagementNotFoundException.class)
    public ResponseEntity<ErrorResponse> bookingNotFoundExceptionHandler(TaskManagementNotFoundException exception){
        ErrorResponse errorResponse=new ErrorResponse(exception.getMessage(),HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> resourceAlreadyExistsException(ResourceAlreadyExistsException exception){
        ErrorResponse errorResponse=new ErrorResponse(exception.getMessage(),HttpStatus.CONFLICT.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

}
