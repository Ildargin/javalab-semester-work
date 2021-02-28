package ru.itis.javalab.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
}