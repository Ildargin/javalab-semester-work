package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.javalab.services.PostsService;

@Controller
public class UserController {

  @Autowired PostsService postsService;

  @GetMapping("/user")
  public String getUserPage(Model model) {
    model.addAttribute("posts", postsService.getAllPostsWithUsers());
    return "user";
  }
}
