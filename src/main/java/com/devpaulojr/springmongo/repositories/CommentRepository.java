package com.devpaulojr.springmongo.repositories;

import com.devpaulojr.springmongo.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findByTextContainingIgnoreCase(String text);

}
