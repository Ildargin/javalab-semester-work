package ru.itis.javalab.services;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.javalab.dto.FormDto;
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
    public void addUser(FormDto formDto) {
        usersRepository.save(User.builder()
                .password(formDto.getPassword())
                .email(formDto.getEmail())
                .build()
        );
    }

    @Override
    public Optional<User> getUserByForm(FormDto formDto) {
        Optional<User> userOptional = usersRepository.findByEmail(formDto.getEmail());
        if(userOptional.isPresent()) {
            String rawPassword = formDto.getPassword();
            String encodedPassword = userOptional.get().getPassword();
            if(passwordEncoder.matches(rawPassword, encodedPassword )){
                return userOptional;
            }
        }
        return Optional.empty();
    }
}
