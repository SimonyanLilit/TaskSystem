package management.system.common.exceptions;

import lombok.Getter;

/**
 * Custom exception class for the cases when the request has no valid authorization.
 */
public abstract class ForbiddenException extends RuntimeException {

    /**
     * Detailed error message to include in a response (optional)
     */
    @Getter
    private String details;

    /**
     * Constructor
     * @param errorMessage error message
     * @param details Detailed error to include in the response
     */
    public ForbiddenException(String errorMessage, String details) {
        super(errorMessage);
        this.details = details;
    }

    /**
     * Constructor
     * @param errorMessage error message
     */
    public ForbiddenException(String errorMessage) {
        super(errorMessage);
        details = null;
    }

    /**
     * Constructor
     * @param errorMessage error message
     * @param err Throwable
     */
    public ForbiddenException(String errorMessage, Throwable err) {
        super(errorMessage, err);
        details = null;
    }
}
