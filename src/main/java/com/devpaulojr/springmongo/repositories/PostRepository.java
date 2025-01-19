package com.devpaulojr.springmongo.repositories;

import com.devpaulojr.springmongo.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


    List<Post> findByAuthorId(String nameAuthor);

    List<Post> findByTitleContainingIgnoreCase(String title);

}
