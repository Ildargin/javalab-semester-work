package ru.itis.javalab.models;


import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "account")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  private String password;
  private String email;
  private String imagePath;
  private String confirmedCode;
  private Date birthDate;


  @Builder.Default
  private Status status = Status.NOT_CONFIRMED;
  @OneToMany(mappedBy = "owner")
  private List<Post> posts;
  @OneToMany(mappedBy = "owner")
  private List<Comment> comments;

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
