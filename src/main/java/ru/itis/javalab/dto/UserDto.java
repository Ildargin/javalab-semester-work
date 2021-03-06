package ru.itis.javalab.dto;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.javalab.models.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
  private Long id;
  private String email;
  private String password;
  private String firstName;
  private String lastName;
  private String imagePath;
  private Date birthDate;

  public static UserDto from(User user) {
    if (user == null) {
      return null;
    }
    return UserDto.builder()
        .id(user.getId())
        .email(user.getEmail())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .password(user.getPassword())
        .build();
  }

  public static List<UserDto> from(List<User> users) {
    return users.stream().map(UserDto::from).collect(Collectors.toList());
  }
}
