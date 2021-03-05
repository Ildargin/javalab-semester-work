package ru.itis.javalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.models.Post;

public interface PostsRepository extends JpaRepository<Post, Long> {}
