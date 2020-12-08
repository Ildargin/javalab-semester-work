package ru.itis.javalab.services;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.javalab.dto.SigninFormDto;
import ru.itis.javalab.dto.UpdateFormDto;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;

import java.util.Optional;


public class UsersServiceImpl implements UsersService {

    private final UsersRepository  usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.usersRepository = usersRepository;
    }

    @Override
    public void updateUser(UpdateFormDto updateFormDto) {
        usersRepository.update(User.builder()
                .id(updateFormDto.getId())
                .birthDate(updateFormDto.getBirthDate())
                .firstName(updateFormDto.getFirstName())
                .lastName(updateFormDto.getLastName())
                .build()
        );
    }

    @Override
    public void addUser(SigninFormDto signinFormDto) {
        usersRepository.save(User.builder()
                .password(signinFormDto.getPassword())
                .email(signinFormDto.getEmail())
                .build()
        );
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByForm(SigninFormDto signinFormDto) {
        Optional<User> userOptional = usersRepository.findByEmail(signinFormDto.getEmail());
        if(userOptional.isPresent()) {
            String rawPassword = signinFormDto.getPassword();
            String encodedPassword = userOptional.get().getPassword();
            if(passwordEncoder.matches(rawPassword, encodedPassword )){
                return userOptional;
            }
        }
        return Optional.empty();
    }
}
