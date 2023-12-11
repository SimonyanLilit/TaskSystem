package management.system.service;

import management.system.dto.requestdto.UserRequest;
import management.system.dto.responsedto.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest request);
}
