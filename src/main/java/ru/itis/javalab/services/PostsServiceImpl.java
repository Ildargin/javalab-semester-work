package ru.itis.javalab.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.PostDto;
import ru.itis.javalab.dto.PostShowingDto;
import ru.itis.javalab.models.Post;
import ru.itis.javalab.repositories.PostsRepository;

@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    private PostsRepository postRepository;

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
    public List<PostShowingDto> getAllPostsWithUsers() {
        return postRepository.findAllWithUsers();
    }
}
