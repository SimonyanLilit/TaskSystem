package management.system.common.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * Custom exception class for the cases when the request has no valid authentication.
 */

@Getter
@Setter
public class UnauthorizedException extends RuntimeException {
    /**
     * Authorization error message details
     */
    private String authError;

    /**
     * Default authorization error message (no details)
     */
    public static final String UNAUTHORIZED_ACCESS_MESSAGE = "Unauthorized access";

    /**
     * Empty Constructor
     */
    public UnauthorizedException() {
        super(UNAUTHORIZED_ACCESS_MESSAGE);
    }

    /**
     * Constructor
     * @param errorMessage error message
     */
    public UnauthorizedException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Constructor
     * @param errorMessage error message
     * @param authError Auth error details
     */
    public UnauthorizedException(String errorMessage, String authError) {
        super(errorMessage);
        this.authError = authError;
    }

    /**
     * Constructor
     * @param errorMessage error message
     * @param err Throwable
     */
    public UnauthorizedException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
