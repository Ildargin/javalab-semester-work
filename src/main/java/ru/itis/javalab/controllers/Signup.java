package ru.itis.javalab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Signup {
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getMainPage() {
        return "signup";
    }
}
