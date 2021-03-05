package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.javalab.services.UsersService;

@Controller
public class ActivateUserController {

  @Autowired
  private UsersService usersService;

  @GetMapping("/confirm/{confirm_code}")
  public String getConfirmPage(Model model, @PathVariable("confirm_code") String confirmCode) {
    boolean isConfirmed = usersService.confirmUser(confirmCode);
    model.addAttribute("isConfirmed", isConfirmed);
    return "confirm";
  }
}
