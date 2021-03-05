package ru.itis.javalab.controllers;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.javalab.dto.SignupFormDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;

@Controller
public class SigninController {

  @Autowired private UsersService usersService;

  @GetMapping(value = "/signin")
  public String getSignInPage() {
    return "signin";
  }

  @PostMapping("/signin")
  public void getAccess(
      SignupFormDto signupFormDto, HttpServletRequest req, HttpServletResponse res) {
    Optional<User> userOptional = usersService.getUserByForm(signupFormDto);
    if (userOptional.isPresent()) {
      HttpSession session = req.getSession(true);
      session.setAttribute("authenticated", true);
      session.setAttribute("user", userOptional.get());
      res.setStatus(200);
    } else {
      res.setStatus(400);
    }
  }
}
