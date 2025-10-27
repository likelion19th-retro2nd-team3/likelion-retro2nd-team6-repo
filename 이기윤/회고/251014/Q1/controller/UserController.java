package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public Map<String, String> getUserCount() {
        return Map.of("message", "사용자 수: " + userService.getUserCount() + "명");
    }
}