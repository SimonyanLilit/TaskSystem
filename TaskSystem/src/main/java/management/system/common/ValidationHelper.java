package management.system.common;

import management.system.dto.requestdto.UserRequest;
import management.system.exception.UserBadRequestException;
import org.apache.commons.lang3.StringUtils;

public class ValidationHelper {

    public static void passwordValidation(String password) {
        if (StringUtils.isEmpty(password)) {
            throw new UserBadRequestException(UserRequest.PASSWORD_NULL_MSG);
        }
        if (password.length() < 8) {
            throw new UserBadRequestException(UserRequest.PASSWORD_SIZE_MSG);
        }
        int countOfDigits = 0;
        int countOfUppercase = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                countOfDigits++;
            } else if (Character.isUpperCase(c)){
                countOfUppercase++;
            }
        }
        if (countOfDigits < 1 || countOfUppercase < 1) {
            throw new UserBadRequestException(UserRequest.PASSWORD_FORMAT_MSG);
        }
    }
}
