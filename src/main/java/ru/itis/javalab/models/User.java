package ru.itis.javalab.models;

import java.sql.Date;
import java.util.UUID;
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
public class User {

  private Long id;
  private String firstName;
  private String lastName;
  private String password;
  private String email;
  private String imagePath;
  private Date birthDate;
  private UUID confirmedCode;

  @Builder.Default
  private Status status = Status.NOT_CONFIRMED;

  public enum Status {
    CONFIRMED("CONFIRMED"),
    NOT_CONFIRMED("NOT_CONFIRMED");

    private final String string;

    Status(String status) {
      this.string = status;
    }

    public String getString() {
      return string;
    }
  }
}
