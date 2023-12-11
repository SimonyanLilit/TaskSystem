package management.system.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import management.system.dto.requestdto.LoginRequest;
import management.system.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Hidden
@Slf4j
@RestController
@RequestMapping("/rest/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @ResponseBody
    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public String login(@RequestBody LoginRequest loginRequest) {
        return tokenService.getToken(loginRequest);
    }
}
