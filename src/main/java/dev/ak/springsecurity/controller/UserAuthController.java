package dev.ak.springsecurity.controller;

import dev.ak.springsecurity.entity.UserAuth;
import dev.ak.springsecurity.service.UserAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    private final UserAuthService userAuthService;
    private final PasswordEncoder passwordEncoder;

    public UserAuthController(UserAuthService userAuthService, PasswordEncoder passwordEncoder) {
        this.userAuthService = userAuthService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserAuth userAuth) {
        userAuth.setPassword(passwordEncoder.encode(userAuth.getPassword()));
        userAuthService.saveUser(userAuth);
        return ResponseEntity.ok("User registered successfully");
    }
}
