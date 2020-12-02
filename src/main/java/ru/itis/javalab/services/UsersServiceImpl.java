package ru.itis.javalab.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.javalab.dto.FormDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;

import java.util.Optional;

import static ru.itis.javalab.dto.UserDto.from;


public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.usersRepository = usersRepository;
    }

    @Override
    public void addUser(FormDto formDto) {
        usersRepository.save(User.builder()
                .password(formDto.getPassword())
                .email(formDto.getEmail())
                .build()
        );
    }

    @Override
    public Boolean validateUser(FormDto formDto) {
        Optional<User> user = usersRepository.findByEmail(formDto.getEmail());
        if (user.isPresent()) {
            String dbPassword = user.get().getPassword().trim();
            return passwordEncoder.matches(formDto.getPassword(), dbPassword);
        } else {
            return false;
        }

    }
}
