package ru.itis.javalab.dto;

import javax.validation.constraints.Email;
import lombok.Data;
import ru.itis.javalab.validation.ValidNames;
import ru.itis.javalab.validation.ValidPassword;

@Data
@ValidNames(message = "{errors.invalid.names}", name = "firstName", surname = "lastName")
public class UserForm {
  @Email(message = "{errors.incorrect.email}")
  private String email;

  @ValidPassword(message = "{errors.invalid.password}")
  private String password;

  private String firstName;
  private String lastName;
}
