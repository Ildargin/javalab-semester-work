package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.javalab.dto.SigninFormDto;

import ru.itis.javalab.services.UsersService;

@Controller
public class SignupController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/signup")
    public String getMainPage() {

        return "signup";
    }

    @PostMapping("/signup")
    public String addUser(SigninFormDto signinFormDto) {
        usersService.addUser(signinFormDto);
        return "redirect:/success";
    }

}


