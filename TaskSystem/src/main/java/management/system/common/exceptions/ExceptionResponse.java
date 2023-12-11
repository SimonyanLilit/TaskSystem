package management.system.common.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.UUID;

/**
 * Exception response object
 */
@Builder
@Getter
@Jacksonized
@JsonInclude(Include.NON_NULL)
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    /**
     * message explaining the application error
     */
    private String message;

    /**
     * application error code
     */
    private String errorCode;

    /**
     * application error detail
     */
    private String errorDetail;

    /**
     * id of the used which information is duplicated
     */
    private UUID conflictingId;

    /**
     * List of error details
     */
    private List<String> errorDetails;

    /**
     * Constructor
     * @param errorMessage error message
     * @param errorCode error code
     */
    public ExceptionResponse(String errorMessage, String errorCode) {
        this.message = errorMessage;
        this.errorCode = errorCode;
    }

    /**
     * Constructor
     * @param errorMessage error message
     * @param errorCode error code
     * @param errorDetail error details (single message)
     */
    public ExceptionResponse(String errorMessage, String errorCode, String errorDetail) {
        this.message = errorMessage;
        this.errorCode = errorCode;
        this.errorDetail = errorDetail;
    }

    /**
     * Constructor
     * @param errorMessage error message
     * @param errorCode error code
     * @param errorDetails list of error detail messages
     */
    public ExceptionResponse(String errorMessage, String errorCode, List<String> errorDetails) {
        this.message = errorMessage;
        this.errorCode = errorCode;
        this.errorDetails = errorDetails;
    }

    /**
     * Constructor
     * @param errorMessage error message
     * @param errorCode error code
     * @param conflictingId UUID of a conflicting object
     */
    public ExceptionResponse(String errorMessage, String errorCode, UUID conflictingId) {
        this.message = errorMessage;
        this.errorCode = errorCode;
        this.conflictingId = conflictingId;
    }
}
