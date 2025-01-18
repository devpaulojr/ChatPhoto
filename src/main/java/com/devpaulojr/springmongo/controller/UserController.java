package com.devpaulojr.springmongo.controller;

import com.devpaulojr.springmongo.dto.PostDto;
import com.devpaulojr.springmongo.dto.UserDto;
import com.devpaulojr.springmongo.model.Post;
import com.devpaulojr.springmongo.model.User;
import com.devpaulojr.springmongo.repositories.UserRepository;
import com.devpaulojr.springmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;

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

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDto userDto){
        User user = service.insertDto(userDto);
        user = repository.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
        ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDto> update(@PathVariable String id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        User user = service.insertDto(userDto);
        user = service.update(id, user);
        return ResponseEntity.noContent().build();
    }
}
