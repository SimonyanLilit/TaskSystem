package management.system.exception;

import management.system.common.exceptions.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public UserNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
