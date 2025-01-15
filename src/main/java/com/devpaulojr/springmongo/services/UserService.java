package com.devpaulojr.springmongo.services;

import com.devpaulojr.springmongo.dto.UserDto;
import com.devpaulojr.springmongo.model.User;
import com.devpaulojr.springmongo.repositories.UserRepository;
import com.devpaulojr.springmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll(){
        List<User> userList = new ArrayList<>();
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public User findById(String id){
        Optional<User> entity = repository.findById(id);
        return entity.orElseThrow(() -> new ObjectNotFoundException("NotFound: Objeto não encontrado!!"));
    }

    @PostMapping
    public User insertDto(UserDto userDto){
        return new User(userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPhone(),
                userDto.getPassword());
    }
}
