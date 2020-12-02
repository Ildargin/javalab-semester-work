package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.javalab.dto.FormDto;
import ru.itis.javalab.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class SigninController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String getMainPage() {
        return "signin";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public void getAccess(FormDto formDto, HttpServletRequest req, HttpServletResponse res) throws IOException {
         Boolean userExist = usersService.validateUser(formDto);
        if (userExist) {
            HttpSession session = req.getSession(true);
            session.setAttribute("authenticated", true);
            res.setStatus(202);
        }
        res.setStatus(202);
        
    }
}
