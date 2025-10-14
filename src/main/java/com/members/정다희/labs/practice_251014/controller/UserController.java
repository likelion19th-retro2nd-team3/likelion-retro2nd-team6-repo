package com.members.정다희.labs.practice_251014.controller;

import com.members.정다희.labs.practice_251014.domain.User;
import com.members.정다희.labs.practice_251014.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        System.out.println("UserController(UserService) 실행");
    }

    public void joinUser() {
        // 실제 서비스가 동작하고 있다면 사용자가 브라우저에 입력한 정보가 들어온다.
        User user = new User();
        user.setName("jeong");
        user.setPassword("1234");
        user.setEmail("test@gmail.com");

        userService.joinUser(user);
    }
}
