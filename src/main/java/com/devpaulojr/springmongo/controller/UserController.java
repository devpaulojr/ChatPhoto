package com.devpaulojr.springmongo.controller;

import com.devpaulojr.springmongo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("id1", "paulo", "paulo@gmail.com"));
        userList.add(new User("id2", "maria", "maria@gmail.com"));
        return ResponseEntity.ok().body(userList);
    }
}
