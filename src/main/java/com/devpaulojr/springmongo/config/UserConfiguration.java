package com.devpaulojr.springmongo.config;

import com.devpaulojr.springmongo.model.User;
import com.devpaulojr.springmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class UserConfiguration implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        var user1 = new User(null,
                "paulo",
                "paulo@gmail.com");

        var user2 = new User(null,
                "leticia",
                "letica@gmail.com");

        var user3 = new User(null,
                "carlos",
                "carlos@gmail.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
