package ru.itis.javalab.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateFormDto {
  private Long id;
  private String firstName;
  private String LastName;
  private Date birthDate;
}
