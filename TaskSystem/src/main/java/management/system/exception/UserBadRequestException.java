package management.system.exception;

import management.system.common.exceptions.BadRequestException;

public class UserBadRequestException extends BadRequestException {
    public UserBadRequestException(String errorMessage) {
        super(errorMessage);
    }
}
