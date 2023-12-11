package management.system.exception;

import management.system.common.exceptions.ApiException;

public class TaskApiException extends ApiException {
    /**
     * Constructor
     *
     * @param errorMessage error message
     */
    public TaskApiException(String errorMessage) {
        super(errorMessage);
    }
}
