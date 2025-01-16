package com.devpaulojr.springmongo.services;

import com.devpaulojr.springmongo.model.Post;
import com.devpaulojr.springmongo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    @GetMapping
    public List<Post> findAll(){
        return repository.findAll();

    }
}
