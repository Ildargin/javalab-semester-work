package ru.itis.javalab.repositories;

import java.util.Optional;
import ru.itis.javalab.models.User;


public interface UsersRepository extends CrudRepository<User> {

  Optional<User> findByEmail(String email);

  Optional<User> findById(Long id);

  boolean saveUser(User user);
}
