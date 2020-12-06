package ru.itis.javalab.models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Post {
    private Long id;
    private Long userId;
    private String text;
    private String title;
    private Integer likes;
    private Integer dislikes;
}