package ru.itis.javalab.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail (String Email);
  Optional<User> findByConfirmedCode (String string);
}
