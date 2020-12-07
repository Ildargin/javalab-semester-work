package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.dto.FormDto;

import ru.itis.javalab.services.UsersService;

@Controller
public class SignupController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getMainPage() {

        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String addUser(FormDto formDto) {
        usersService.addUser(formDto);
        return "redirect:/success";
    }


}


