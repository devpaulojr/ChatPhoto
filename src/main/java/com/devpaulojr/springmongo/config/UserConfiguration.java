package com.devpaulojr.springmongo.config;

import com.devpaulojr.springmongo.dto.AuthorDto;
import com.devpaulojr.springmongo.dto.CommentDto;
import com.devpaulojr.springmongo.dto.PostDto;
import com.devpaulojr.springmongo.model.Comment;
import com.devpaulojr.springmongo.model.Post;
import com.devpaulojr.springmongo.model.User;
import com.devpaulojr.springmongo.repositories.CommentRepository;
import com.devpaulojr.springmongo.repositories.PostRepository;
import com.devpaulojr.springmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Configuration
public class UserConfiguration implements CommandLineRunner {

    Random random = new Random();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();
        commentRepository.deleteAll();

        User paulo = new User(
                null,
                "paulo santana",
                "paulo@gmail.com",
                "83940028922",
                "400289"
        );

        var clara = new User(
                null,
                "clara gomes",
                "clara@gmail.com",
                "8935421247",
                "880dsd");

        var carlos = new User(
                null,
                "carlos andrade",
                "carlos@gmail.com",
                "83976634566",
                "Carlos124");

        userRepository.saveAll(Arrays.asList(paulo, clara, carlos));


        var post1 = new Post(
                null,
                LocalDate.of(2004, 1, 12),
                "Cachorros pulando",
                "Passeando com cachorros alegres",
                new AuthorDto(paulo)
        );


        var post2 = new Post(
                null,
                LocalDate.now(),
                "Foto família",
                "Foto com a galera, geral!!",
                new AuthorDto(carlos)
        );

        var post3 = new Post(
                null,
                LocalDate.of(2012, 7,7),
                "+1 foto de cachorro",
                "Novamente passeando com cachorros alegres",
                new AuthorDto(paulo)
        );

        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        var comment1 = new Comment(
                null,
                "que cachorro lindo!!",
                LocalDate.now(),
                random.nextInt(),
                new PostDto(post1),
                new AuthorDto(clara)
        );

        var comment2 = new Comment(
                null,
                "galera da pesada",
                LocalDate.now(),
                random.nextInt(),
                new PostDto(post2),
                new AuthorDto(paulo)
        );

        var comment3 = new Comment(
                null,
                "Quanto cachorro kkk",
                LocalDate.now(),
                random.nextInt(),
                new PostDto(post1),
                new AuthorDto(carlos)
        );

        paulo.getPosts().addAll(Arrays.asList(post1, post2));
        carlos.getPosts().add(post2);

        userRepository.save(paulo);
        userRepository.save(carlos);

        commentRepository.saveAll(Arrays.asList(comment1, comment2, comment3));
    }
}