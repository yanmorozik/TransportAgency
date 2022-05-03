package eu.morozik.transportagency.controller;

import eu.morozik.transportagency.dto.AuthenticationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationDto request) {
        return null;
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
        return null;
    }
}
