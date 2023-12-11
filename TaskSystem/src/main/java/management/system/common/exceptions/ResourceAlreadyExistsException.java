package management.system.common.exceptions;

import lombok.Getter;

import java.util.UUID;

/**
 * Exception for requests to create an object that already exists
 */
@Getter
public class ResourceAlreadyExistsException extends RuntimeException {

    /**
     * Conflicting UUID to include in a response (optional)
     */
    private UUID conflictingId;

    /**
     * Constructor
     * @param errorMessage error message
     */
    public ResourceAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Constructor
     * @param errorMessage error message
     * @param conflictingId UUID of the conflicting object
     */
    public ResourceAlreadyExistsException(String errorMessage, UUID conflictingId) {
        super(errorMessage);
        this.conflictingId = conflictingId;
    }
}
