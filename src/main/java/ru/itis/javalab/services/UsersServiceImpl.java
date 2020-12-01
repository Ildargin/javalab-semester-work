package ru.itis.javalab.services;

import ru.itis.javalab.dto.FormDto;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;

import java.util.List;

import static ru.itis.javalab.dto.UserDto.from;


public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
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
        usersRepository.save(User.builder()
                .password(formDto.getPassword())
                .email(formDto.getEmail())
                .build()
        );
    }
}
