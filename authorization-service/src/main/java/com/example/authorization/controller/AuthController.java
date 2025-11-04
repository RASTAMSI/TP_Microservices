package com.example.authorization.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${security.productcomposite.admin.username}")
    private String adminUser;

    @Value("${security.productcomposite.admin.password}")
    private String adminPwd;

    @Value("${security.productcomposite.user.username}")
    private String userUser;

    @Value("${security.productcomposite.user.password}")
    private String userPwd;

    @GetMapping("/validate")
    public ResponseEntity<Void> validate(
            @RequestHeader("username") String username,
            @RequestHeader("password") String password,
            @RequestHeader("role") String role) {

        if (role.equalsIgnoreCase("ADMIN") && username.equals(adminUser) && password.equals(adminPwd)) {
            return ResponseEntity.ok().build();
        }

        if (role.equalsIgnoreCase("USER") && username.equals(userUser) && password.equals(userPwd)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
