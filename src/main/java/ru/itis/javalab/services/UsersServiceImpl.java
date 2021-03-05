package ru.itis.javalab.services;

import java.util.Optional;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.SignupFormDto;
import ru.itis.javalab.dto.UpdateFormDto;
import ru.itis.javalab.models.Email;
import ru.itis.javalab.models.User;
import ru.itis.javalab.models.User.Status;
import ru.itis.javalab.repositories.UsersRepository;
import ru.itis.javalab.utils.EmailUtil;
import ru.itis.javalab.utils.MailsGenerator;

@Service
public class UsersServiceImpl implements UsersService {

  @Autowired private UsersRepository usersRepository;

  @Autowired private PasswordEncoder passwordEncoder;

  @Autowired private EmailUtil emailUtil;

  @Autowired private MailsGenerator mailsGenerator;

  @Value("${server.url}")
  private String serverUrl;

  @Value("${spring.mail.username}")
  private String from;

  @Override
  public void updateUser(UpdateFormDto updateFormDto) {
    usersRepository.save(
        User.builder()
            .id(updateFormDto.getId())
            .birthDate(updateFormDto.getBirthDate())
            .firstName(updateFormDto.getFirstName())
            .lastName(updateFormDto.getLastName())
            .build());
  }

  @Override
  public void addUser(SignupFormDto signupFormDto) {
    User newUser =
        User.builder()
            .password(passwordEncoder.encode(signupFormDto.getPassword()))
            .confirmedCode(UUID.randomUUID().toString())
            .email(signupFormDto.getEmail())
            .build();
    usersRepository.save(newUser);
    String confirmMail = mailsGenerator.getMailForConfirm(serverUrl, newUser.getConfirmedCode().toString());
    Email email = new Email(from, newUser.getEmail(), "Регистрация", confirmMail);
    emailUtil.sendMail(email);
  }

  @Override
  public Boolean confirmUser(String confirmCode) {
    Optional<User> userOptional= usersRepository.findByConfirmedCode(confirmCode);
    if (userOptional.isPresent()){
      User user = userOptional.get();
      user.setStatus(Status.CONFIRMED);
      usersRepository.save(user);
      return true;
    }
    return false;
  }

  @Override
  public Optional<User> getUserById(Long id) {
    return usersRepository.findById(id);
  }

  @Override
  public Optional<User> getUserByForm(SignupFormDto signupFormDto) {
    Optional<User> userOptional = usersRepository.findByEmail(signupFormDto.getEmail());
    if (userOptional.isPresent()) {
      String rawPassword = signupFormDto.getPassword();
      String encodedPassword = userOptional.get().getPassword();
      if (passwordEncoder.matches(rawPassword, encodedPassword)) {
        return userOptional;
      }
    }
    return Optional.empty();
  }
}
