package ru.itis.javalab.services;

import java.util.List;
import javax.servlet.http.HttpSession;
import ru.itis.javalab.dto.PostDto;
import ru.itis.javalab.dto.PostShowingDto;

public interface PostsService {
  void addPost(PostDto PostDto, HttpSession session);
  List<PostShowingDto> getAllPostsWithUsers();
}
