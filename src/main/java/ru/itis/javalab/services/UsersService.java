package ru.itis.javalab.services;

import ru.itis.javalab.dto.SigninFormDto;
import ru.itis.javalab.dto.UpdateFormDto;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;

import java.util.Optional;


public interface UsersService {
    void updateUser(UpdateFormDto updateFormDto);
    void addUser(SigninFormDto signinFormDto);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByForm(SigninFormDto signinFormDto);
}
