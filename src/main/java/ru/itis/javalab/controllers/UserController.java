package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.services.PostsService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    PostsService postsService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getMainPage(Model model) {
        model.addAttribute("posts", postsService.getAllPostsWithUsers());
        return "user";
    }
}