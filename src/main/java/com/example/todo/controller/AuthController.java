package com.example.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private static final Map<String, String> USERS = Map.of(
            "rahul", "aju@123",
            "deepika", "abc@111"
    );

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if (username != null && password != null && password.equals(USERS.get(username))) {
            return ResponseEntity.ok(Map.of("username", username));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "Invalid username or password"));
    }
}
