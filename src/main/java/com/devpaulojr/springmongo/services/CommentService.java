package com.devpaulojr.springmongo.services;

import com.devpaulojr.springmongo.model.Comment;
import com.devpaulojr.springmongo.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    public List<Comment> findAll(){
        return repository.findAll();
    }

    public List<Comment> findByText(@RequestParam String text){
        return repository.findByTextContainingIgnoreCase(text);
    }
}
