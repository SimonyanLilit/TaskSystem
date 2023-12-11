package management.system.service;

import management.system.dto.requestdto.LoginRequest;

public interface TokenService {

    String getToken(LoginRequest loginRequest);
}
