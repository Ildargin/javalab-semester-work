package ru.itis.javalab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SuccessController {
    @GetMapping("/success")
    public String getMainPage() {
        return "success";
    }
}
