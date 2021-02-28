package ru.itis.javalab.services;

import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.SignupFormDto;
import ru.itis.javalab.dto.UpdateFormDto;
import ru.itis.javalab.models.User;

@Service
public interface UsersService {

  void updateUser(UpdateFormDto updateFormDto);

  void addUser(SignupFormDto signupFormDto, HttpSession session);

  Optional<User> getUserById(Long id);

  Optional<User> getUserByForm(SignupFormDto signupFormDto);
}
