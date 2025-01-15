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

        var user1 = new User(null,
                "paulo",
                "paulo@gmail.com",
                "83940028922",
                "400289");

        var user2 = new User(null,
                "clara",
                "clara@gmail.com",
                "8935421247",
                "880dsd");

        var user3 = new User(null,
                "carlos",
                "carlos@gmail.com",
                "83976634566",
                "Carlos124");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
