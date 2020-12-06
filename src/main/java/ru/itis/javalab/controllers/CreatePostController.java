package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.dto.PostDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.PostsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class CreatePostController {
    @Autowired
    private PostsService postsService;

    @RequestMapping(value = "/createpost", method = RequestMethod.GET)
    public String getPostPage() {
        return "createpost";
    }

    @RequestMapping(value = "/createpost", method = RequestMethod.POST)
    public void getAccess(PostDto postDto, HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        postDto.setUserId(user.getId());
        postsService.addPost(postDto);
        res.setStatus(200);
    }

}
