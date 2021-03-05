package ru.itis.javalab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostShowingDto {
  private Long id;
  private String text;
  private String title;
  private String firstName;
  private String lastName;
  private String email;
  private String image_path;
}
