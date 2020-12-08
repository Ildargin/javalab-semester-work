package ru.itis.javalab.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Date;

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
}
