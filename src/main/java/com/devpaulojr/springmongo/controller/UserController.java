package com.devpaulojr.springmongo.controller;

import com.devpaulojr.springmongo.dto.UserDto;
import com.devpaulojr.springmongo.model.User;
import com.devpaulojr.springmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        List<User> list = service.findAll();
        List<UserDto> userDtoList = list.stream().map(UserDto::new).toList();
        return ResponseEntity.ok().body(userDtoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id){
        var entity = service.findById(id);
        var userDto = new UserDto(entity);
        return ResponseEntity.ok().body(userDto);
    }
}
