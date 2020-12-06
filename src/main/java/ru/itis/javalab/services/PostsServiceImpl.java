package ru.itis.javalab.services;

import ru.itis.javalab.dto.PostDto;
import ru.itis.javalab.models.Post;
import ru.itis.javalab.repositories.PostsRepository;

import java.util.List;

public class PostsServiceImpl implements PostsService {

    private final PostsRepository postRepository;

    public PostsServiceImpl(PostsRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void addPost(PostDto postDto) {
        postRepository.save(
                Post.builder()
                        .userId(postDto.getUserId())
                        .title(postDto.getTitle())
                        .text(postDto.getText())
                        .build()
        );
    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }
}
