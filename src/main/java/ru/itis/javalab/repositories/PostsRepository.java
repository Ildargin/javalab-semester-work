package ru.itis.javalab.repositories;

import java.util.List;
import ru.itis.javalab.dto.PostShowingDto;
import ru.itis.javalab.models.Post;


public interface PostsRepository extends CrudRepository<Post> {

  List<PostShowingDto> findAllWithUsers();
}
