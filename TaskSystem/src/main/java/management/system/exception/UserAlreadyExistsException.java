package management.system.exception;

import management.system.common.exceptions.ResourceAlreadyExistsException;

import java.util.UUID;

public class UserAlreadyExistsException extends ResourceAlreadyExistsException {
    public UserAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }

    public UserAlreadyExistsException(String errorMessage, UUID conflictingId) {
        super(errorMessage, conflictingId);
    }
}
