package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.javalab.dto.FormDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@Controller
public class SigninController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String getMainPage() {
        return "signin";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public void getAccess(FormDto formDto, HttpServletRequest req, HttpServletResponse res) {
        Optional<User> userOptional = usersService.getUserByForm(formDto);
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
