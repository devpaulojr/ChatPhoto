package com.devpaulojr.springmongo.controller;

import com.devpaulojr.springmongo.dto.CommentDto;
import com.devpaulojr.springmongo.model.Comment;
import com.devpaulojr.springmongo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    @Autowired
    private CommentService service;

    @GetMapping
    public ResponseEntity<List<CommentDto>> findAll(){
        List<Comment> entity = service.findAll();
        List<CommentDto> dtoList = entity.stream().map(CommentDto::new).toList();
        return ResponseEntity.ok().body(dtoList);
    }
}
