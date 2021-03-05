package ru.itis.javalab.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.javalab.dto.SignupFormDto;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.services.UsersService;

@Controller
public class SignupController {

  @Autowired private UsersService usersService;

  @GetMapping("/signup")
  public String getMainPage( Model model) {
    model.addAttribute("userForm", new UserForm());
    return "signup";
  }

  @PostMapping("/signup")
  public void addUser(SignupFormDto signupFormDto, HttpServletResponse res) throws IOException {
    usersService.addUser(signupFormDto);
    res.setStatus(200);
  }
}
