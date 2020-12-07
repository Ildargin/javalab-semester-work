package ru.itis.javalab.repositories;

import ru.itis.javalab.dto.PostShowingDto;
import ru.itis.javalab.models.Post;

import java.util.List;


public interface PostsRepository extends CrudRepository<Post> {
    List<PostShowingDto> findAllWithUsers();
}
