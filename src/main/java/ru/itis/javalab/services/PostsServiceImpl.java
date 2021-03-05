package ru.itis.javalab.services;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.PostDto;
import ru.itis.javalab.dto.PostShowingDto;
import ru.itis.javalab.models.Post;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.PostsRepository;

@Service
public class PostsServiceImpl implements PostsService {

  @Autowired private PostsRepository postsRepository;

  @Override
  public void addPost(PostDto postDto, HttpSession session) {
    User user = (User) session.getAttribute("user");
    if (user != null) {
      postsRepository.save(
          Post.builder().title(postDto.getTitle()).text(postDto.getText()).owner(user).build());
    }
  }

  public List<PostShowingDto> getAllPostsWithUsers() {
    List<PostShowingDto> postsShowingList = new ArrayList<>();
    List<Post> posts = postsRepository.findAll();
    for (Post post : posts) {
      User user = post.getOwner();
      postsShowingList.add(
          PostShowingDto.builder()
              .id(post.getId())
              .title(post.getTitle())
              .text(post.getText())
              .firstName(user.getFirstName())
              .lastName(user.getLastName())
              .email(user.getEmail())
              .image_path(user.getImagePath())
              .build());
    }

    return postsShowingList;
  }
}
