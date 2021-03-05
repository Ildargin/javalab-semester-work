package ru.itis.javalab.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.javalab.dto.PostDto;
import ru.itis.javalab.services.PostsService;

@Controller
public class CreatePostController {

  @Autowired private PostsService postsService;

  @GetMapping("/createpost")
  public String getPostPage() {
    return "createpost";
  }

  @PostMapping("/createpost")
  public void getAccess(PostDto postDto, HttpServletResponse res, HttpSession session) {
    postsService.addPost(postDto, session);
    res.setStatus(200);
  }
}
