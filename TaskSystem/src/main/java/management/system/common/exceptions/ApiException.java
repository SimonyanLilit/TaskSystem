package management.system.common.exceptions;

/**
 * Custom exception class for application general exceptions.
 */
public abstract class ApiException extends RuntimeException {
    /**
     * Constructor
     *
     * @param errorMessage error message
     */
    protected ApiException(String errorMessage) {
        super(errorMessage);
    }
}
