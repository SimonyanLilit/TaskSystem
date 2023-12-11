package management.system.common.exceptions;

/**
 * Custom exception class for the cases when the entity with given details was not found.
 */
public abstract class EntityNotFoundException extends RuntimeException {
    /**
     * Constructor
     * @param errorMessage error message
     */
    protected EntityNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Constructor
     * @param errorMessage error message
     * @param err Throwable
     */
    protected EntityNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
