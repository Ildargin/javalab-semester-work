package ru.itis.javalab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }
}
