package management.system.dto.requestdto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import management.system.model.UserEntity;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserRequest {

    public static final String INVALID_NAME_FORMAT_MSG = "Invalid name format. Name permitted characters: a-z, A-Z, 0-9, underscore (_), minus (-), plus (+), ampersand (&), asterisk (*), period (.), and at sign(@).";
    public static final String NAME_NULL_MSG = "The name of the user can not be null or empty";
    public static final String NAME_REGEX = "^[a-zA-Z0-9_+&*.@-]*$";
    public static final int NAME_SIZE_MIN = 3;
    public static final int NAME_SIZE_MAX = 256;
    public static final String NAME_SIZE_MSG = "Name length must have between " + NAME_SIZE_MIN + " and " + NAME_SIZE_MAX + " characters.";


    public static final String INVALID_SURNAME_FORMAT_MSG = "Invalid username format. Username permitted characters: a-z, A-Z, 0-9, underscore (_), minus (-), plus (+), ampersand (&), asterisk (*), period (.), and at sign(@).";
    public static final String SURNAME_NULL_MSG = "The username of the user can not be null or empty";
    public static final String SURNAME_REGEX = "^[a-zA-Z0-9_+&*.@-]*$";
    public static final int SURNAME_SIZE_MIN = 3;
    public static final int SURNAME_SIZE_MAX = 256;
    public static final String SURNAME_SIZE_MSG = "Name length must have between " + SURNAME_SIZE_MIN + " and " + SURNAME_SIZE_MAX + " characters.";


    public static final int EMAIL_SIZE_MIN = 6;
    public static final int EMAIL_SIZE_MAX = 256;
    public static final String EMAIL_SIZE_MSG = "Email length must have between " + EMAIL_SIZE_MIN + " and " + EMAIL_SIZE_MAX + " characters.";
    public static final String EMAIL_NULL_MSG = "Email must not be null or empty.";
    public static final String EMAIL_EXIST = "The requested email already exists.";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,15}$"; //regexp comes from OWASP Validation Regex Repository
    public static final String INVALID_EMAIL_FORMAT_MSG = "Invalid email format. Email permitted characters: a-z, A-Z, 0-9, underscore (_), minus (-), plus (+), ampersand (&), asterisk (*), period (.), and at sign(@).";


    public static final String PASSWORD_NULL_MSG = "Password can not be null or empty";
    public static final String PASSWORD_SIZE_MSG = "Password must contain min 8 characters";
    public static final String PASSWORD_FORMAT_MSG = "Password must contain min 1 uppercase and 1 digit";

    @Schema(description = "The name of the User", example = "Jon", required = true,
            pattern = NAME_REGEX, minLength = NAME_SIZE_MIN, maxLength = NAME_SIZE_MAX)
    @NotEmpty(message = NAME_NULL_MSG)
    @Pattern(regexp = NAME_REGEX, message = INVALID_NAME_FORMAT_MSG)
    @Length(min = NAME_SIZE_MIN, max = NAME_SIZE_MAX, message = NAME_SIZE_MSG)
    private String name;

    @Schema(description = "The surname of the User", example = "Smith", required = true,
            pattern = SURNAME_REGEX, minLength = SURNAME_SIZE_MIN, maxLength = SURNAME_SIZE_MAX)
    @NotEmpty(message = SURNAME_NULL_MSG)
    @Pattern(regexp = SURNAME_REGEX, message = INVALID_SURNAME_FORMAT_MSG)
    @Length(min = SURNAME_SIZE_MIN, max = SURNAME_SIZE_MAX, message = SURNAME_SIZE_MSG)
    private String surname;

    @Schema(description = "The email of the User", example = "system@management.com", required = true,
            pattern = EMAIL_REGEX, minLength = EMAIL_SIZE_MIN, maxLength = EMAIL_SIZE_MAX)
    @NotEmpty(message = EMAIL_NULL_MSG)
    @Pattern(regexp = EMAIL_REGEX, message = INVALID_EMAIL_FORMAT_MSG)
    @Length(min = EMAIL_SIZE_MIN, max = EMAIL_SIZE_MAX, message = EMAIL_SIZE_MSG)
    private String email;

    @Schema(description = "The password of the User", required = true)
    private String password;

    public UserEntity toEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setSurname(surname);
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        return userEntity;
    }
}
