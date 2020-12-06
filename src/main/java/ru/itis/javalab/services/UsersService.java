package ru.itis.javalab.services;

import ru.itis.javalab.dto.FormDto;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Optional;


public interface UsersService {
    void addUser(FormDto formDto);
    Optional<User> getUserByForm(FormDto formDto);
}
