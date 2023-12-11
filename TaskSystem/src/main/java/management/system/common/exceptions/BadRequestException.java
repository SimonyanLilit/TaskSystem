package management.system.common.exceptions;

/**
 * Custom exception class for the cases when invalid request was send to the endpoint
 */
public abstract class BadRequestException extends RuntimeException {

    public BadRequestException(String errorMessage) {
        super(errorMessage);
    }
}
