package management.system.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import management.system.common.ValidationHelper;
import management.system.dto.requestdto.UserRequest;
import management.system.dto.responsedto.UserResponse;
import management.system.exception.UserAlreadyExistsException;
import management.system.exception.UserApiException;
import management.system.model.UserEntity;
import management.system.repository.UserRepository;
import management.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserResponse createUser(UserRequest request) {
        // validate password
        ValidationHelper.passwordValidation(request.getPassword());
        UserEntity user = null;
        try {
            user = userRepository.getByEmail(request.getEmail());
        } catch (Exception e) {
            throw new UserApiException("Problem occurred while creating the user");
        }
        if (user != null) {
            throw new UserAlreadyExistsException("User already exists with given email");
        }
        try {
            user = userRepository.save(request.toEntity());
        } catch (Exception e) {
            throw new UserApiException("Problem occurred while creating the user");
        }
        return new ObjectMapper().convertValue(user, UserResponse.class);
    }



}
