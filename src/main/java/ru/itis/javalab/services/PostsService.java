package ru.itis.javalab.services;

import ru.itis.javalab.dto.PostDto;
import ru.itis.javalab.models.Post;

import java.util.List;


public interface PostsService {
    void addPost(PostDto PostDto);
    List<Post> getAllPosts();
}
