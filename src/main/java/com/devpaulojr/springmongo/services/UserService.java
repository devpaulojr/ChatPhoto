package com.devpaulojr.springmongo.services;

import com.devpaulojr.springmongo.model.User;
import com.devpaulojr.springmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll(){
        List<User> userList = new ArrayList<>();
        return repository.findAll();
    }
}
