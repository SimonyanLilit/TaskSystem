package management.system.common.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Exception response handler: maps exceptions to an HTTP status code
 * Each exception is logged here before it's returned in a response
 */
@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Maps BadRequestException to 400
     * @return ResponseEntity{@literal <}ExceptionResponse{@literal >}
     */
    @ExceptionHandler(BadRequestException.class)
    public @ResponseBody ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException exception) {
        log.error(exception.getMessage(), exception);
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), ApplicationErrorCode.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    /**
     * Maps EntityNotFoundException to 404
     * @param exception EntityNotFoundException
     * @return ResponseEntity{@literal <}ExceptionResponse{@literal >}
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public @ResponseBody
    ResponseEntity<ExceptionResponse> handleEntityNotFoundException(EntityNotFoundException exception) {
        log.error(exception.getMessage(), exception);
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), ApplicationErrorCode.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }
    /**
     * Maps ApiException to 500
     * @return ResponseEntity{@literal <}ExceptionResponse{@literal >}
     */
    @ExceptionHandler(ApiException.class)
    public @ResponseBody ResponseEntity<ExceptionResponse> handleApiException(ApiException exception) {
        log.error(exception.getMessage(), exception);
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), ApplicationErrorCode.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }

    /**
     * Maps ResourceAlreadyExistsException to 409
     * @return ResponseEntity{@literal <}ExceptionResponse{@literal >}
     */
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public @ResponseBody ResponseEntity<ExceptionResponse> handleResourceAlreadyExistsException(ResourceAlreadyExistsException exception) {
        log.error(exception.getMessage(), exception);
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), ApplicationErrorCode.ALREADY_EXISTS, exception.getConflictingId());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponse);
    }

    /**
     * Maps UnauthorizedException to 401
     * @return ResponseEntity{@literal <}ExceptionResponse{@literal >}
     */
    @ExceptionHandler(UnauthorizedException.class)
    public @ResponseBody ResponseEntity<ExceptionResponse> handleUnauthorizedException(UnauthorizedException exception) {
        log.error(exception.getMessage(), exception);
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), ApplicationErrorCode.UNAUTHORIZED, exception.getAuthError());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exceptionResponse);
    }

    /**
     * Maps ForbiddenException to 403
     * @return ResponseEntity{@literal <}ExceptionResponse{@literal >}
     */
    @ExceptionHandler(ForbiddenException.class)
    public @ResponseBody ResponseEntity<ExceptionResponse> handleForbiddenException(ForbiddenException exception) {
        log.error(exception.getMessage(), exception);
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), ApplicationErrorCode.FORBIDDEN, exception.getDetails());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionResponse);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> details = new ArrayList<>();

        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }

        ExceptionResponse exceptionResponse = new ExceptionResponse("Invalid request", ApplicationErrorCode.BAD_REQUEST, details);
        return ResponseEntity.status(status).body(exceptionResponse);
    }
}
