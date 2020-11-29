package ru.itis.javalab.services;

import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;

import java.util.List;


public interface UsersService {
    void addUser(UserDto userDto);
}
