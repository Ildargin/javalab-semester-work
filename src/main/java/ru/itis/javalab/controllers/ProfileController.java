package ru.itis.javalab.controllers;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import ru.itis.javalab.dto.UpdateFormDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;

@Controller
public class ProfileController {

  @Autowired private UsersService usersService;

  @GetMapping("/profile")
  public String getProfilePage(Model model, HttpSession session) {
    User user = (User) session.getAttribute("user");
    model.addAttribute("user", user);
    return "profile";
  }

  @PostMapping("/profile")
  public void updateProfilePage(
      UpdateFormDto updateFormDto,
      HttpServletRequest req,
      HttpServletResponse res,
      HttpSession session) {
    User user = (User) session.getAttribute("user");
    if (user == null) {
      res.setStatus(400);
    } else {
      Long userId = user.getId();
      updateFormDto.setId(userId);
      usersService.updateUser(updateFormDto);
      Optional<User> userUpdated = usersService.getUserById(userId);
      if (userUpdated.isPresent()) {
        session.setAttribute("user", userUpdated.get());
        res.setStatus(200);
      } else {
        res.setStatus(400);
      }
    }
  }

  @PostMapping("/profile/updateimage")
  public void updateProfileImage(@RequestParam CommonsMultipartFile file, HttpSession session) {
    //    TODO: method
  }
}
