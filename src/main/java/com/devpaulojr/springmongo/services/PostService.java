package com.devpaulojr.springmongo.services;

import com.devpaulojr.springmongo.dto.PostDto;
import com.devpaulojr.springmongo.model.Post;
import com.devpaulojr.springmongo.model.User;
import com.devpaulojr.springmongo.repositories.PostRepository;
import com.devpaulojr.springmongo.repositories.UserRepository;
import com.devpaulojr.springmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Post findById(@PathVariable String id){
        Optional<Post> postList = postRepository.findById(id);
        return postList.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!!"));
    }

    @GetMapping(value = "/{find}/{id}")
    public List<Post> findByIdUser(@PathVariable String id){
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return postRepository.findByAuthorId(user.get().getId());
        }
        throw new ObjectNotFoundException("Usuário com ID " + id + " não encontrado!");
    }
}
