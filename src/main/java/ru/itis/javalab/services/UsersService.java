package ru.itis.javalab.services;

import ru.itis.javalab.dto.FormDto;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;

import java.util.List;


public interface UsersService {
    void addUser(FormDto formDto);
    Boolean validateUser(FormDto formDto);
}
