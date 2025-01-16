package com.devpaulojr.springmongo.controller;

import com.devpaulojr.springmongo.dto.PostDto;
import com.devpaulojr.springmongo.model.Post;
import com.devpaulojr.springmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<List<PostDto>> findAll(){
        List<Post> postList = service.findAll();
        List<PostDto> postDtoList = postList.stream().map(PostDto::new).toList();
        return ResponseEntity.ok().body(postDtoList);
    }
}
