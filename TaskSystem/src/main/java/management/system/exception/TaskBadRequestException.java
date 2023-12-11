package management.system.exception;

import management.system.common.exceptions.BadRequestException;

public class TaskBadRequestException extends BadRequestException {
    public TaskBadRequestException(String errorMessage) {
        super(errorMessage);
    }
}
