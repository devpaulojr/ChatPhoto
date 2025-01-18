package com.devpaulojr.springmongo.repositories;

import com.devpaulojr.springmongo.model.Post;
import com.devpaulojr.springmongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User getReferenceById(String id);
}
