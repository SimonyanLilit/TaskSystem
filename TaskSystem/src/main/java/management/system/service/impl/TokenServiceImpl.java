package management.system.service.impl;

import management.system.config.JwtUtil;
import management.system.dto.requestdto.LoginRequest;
import management.system.exception.UserApiException;
import management.system.exception.UserBadRequestException;
import management.system.model.UserEntity;
import management.system.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    public String getToken(LoginRequest loginRequest) {
        String token = null;
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            String email = authentication.getName();
            UserEntity user = new UserEntity(email, "");
            token = jwtUtil.createToken(user);

        } catch (BadCredentialsException e) {
            throw new UserBadRequestException("Invalid username or password");
        } catch (Exception e) {
            throw new UserApiException("Error occurred while getting token");
        }
        return token;
    }

}
