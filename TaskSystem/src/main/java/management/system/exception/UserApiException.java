package management.system.exception;

import management.system.common.exceptions.ApiException;

public class UserApiException extends ApiException {
    /**
     * Constructor
     *
     * @param errorMessage error message
     */
    public UserApiException(String errorMessage) {
        super(errorMessage);
    }
}
