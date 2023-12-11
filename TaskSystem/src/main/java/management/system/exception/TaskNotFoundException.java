package management.system.exception;

import management.system.common.exceptions.EntityNotFoundException;

public class TaskNotFoundException extends EntityNotFoundException {
    public TaskNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public TaskNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage,err);
    }
}
