package ru.itis.javalab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Main {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMainPage() {
        return "index";
    }
}
