package management.system.exception;

import management.system.common.exceptions.ForbiddenException;

public class UserForbiddenException extends ForbiddenException {
    public UserForbiddenException(String errorMessage, String details) {
        super(errorMessage, details);
    }

    public UserForbiddenException(String errorMessage) {
        super(errorMessage);
    }

    public UserForbiddenException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
