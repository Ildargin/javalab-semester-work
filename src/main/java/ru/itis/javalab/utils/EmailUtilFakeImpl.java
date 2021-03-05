package ru.itis.javalab.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.itis.javalab.models.Email;
import ru.itis.javalab.repositories.UsersRepository;



@Profile("dev")
@Component
public class EmailUtilFakeImpl implements EmailUtil {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public void sendMail(Email email) {
      System.out.println(email);
    }
}