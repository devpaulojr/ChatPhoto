package com.devpaulojr.springmongo.services;

import com.devpaulojr.springmongo.model.Comment;
import com.devpaulojr.springmongo.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    public List<Comment> findAll(){
        return repository.findAll();
    }
}
