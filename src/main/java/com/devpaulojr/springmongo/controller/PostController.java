package com.devpaulojr.springmongo.controller;

import com.devpaulojr.springmongo.controller.util.UrlDecoder;
import com.devpaulojr.springmongo.dto.PostDto;
import com.devpaulojr.springmongo.model.Post;
import com.devpaulojr.springmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDto> findById(@PathVariable String id){
        Post post = service.findById(id);
        return ResponseEntity.ok().body(new PostDto(post));
    }

    @GetMapping(value = "/find/title")
    public ResponseEntity<List<PostDto>> findByTitle(@RequestParam String title){
        title = UrlDecoder.decodeParam(title);
        List<Post> entity = service.findByTitle(title);
        List<PostDto> dtoList = entity.stream().map(PostDto::new).toList();
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<List<PostDto>> getPostsByAuthorId(@PathVariable String id){
        List<Post> listPost = service.findByIdUser(id);
        List<PostDto> postDtoList = listPost.stream().map(PostDto::new).toList();
        return ResponseEntity.ok().body(postDtoList);
    }
}
