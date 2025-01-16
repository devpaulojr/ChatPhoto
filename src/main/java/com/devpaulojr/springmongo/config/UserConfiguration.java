package com.devpaulojr.springmongo.config;

import com.devpaulojr.springmongo.dto.AuthorDto;
import com.devpaulojr.springmongo.model.Post;
import com.devpaulojr.springmongo.model.User;
import com.devpaulojr.springmongo.repositories.PostRepository;
import com.devpaulojr.springmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class UserConfiguration implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User paulo = new User(
                null,
                "paulo",
                "paulo@gmail.com",
                "83940028922",
                "400289");

        var clara = new User(
                null,
                "clara",
                "clara@gmail.com",
                "8935421247",
                "880dsd");

        var carlos = new User(
                null,
                "carlos",
                "carlos@gmail.com",
                "83976634566",
                "Carlos124");

        userRepository.saveAll(Arrays.asList(paulo, clara, carlos));

        var authorPaulo = new AuthorDto(
                paulo
        );

        var authorCarlos = new AuthorDto(
                carlos
        );

        var post1 = new Post(
                null,
                LocalDate.of(2004, 1, 12),
                "Cachorros pulando",
                "Passeando com cachorros alegres",
                authorPaulo
        );


        var post2 = new Post(
                null,
                 LocalDate.now(),
                "Foto família",
                "Foto com a galera, geral!!",
                authorCarlos
        );

        var post3 = new Post(
                null,
                LocalDate.of(2012, 7,7),
                "+1 foto de cachorro",
                "Novamente passeando com cachorros alegres",
                authorPaulo
        );

        postRepository.saveAll(Arrays.asList(post1, post2, post3));
    }
}
