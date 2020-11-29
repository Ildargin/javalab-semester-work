package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Optional;


public interface UsersRepository extends CrudRepository<User> {
    Optional<User> findByFirstnameAndPassword(String firstName, String lastName);
}
