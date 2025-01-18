package com.devpaulojr.springmongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "user")
public class User implements Serializable {

    @Id
    private String id;

    private String name;
    private String email;
    private String phone;
    private String password;

    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public User(String id, String name, String email, String phone, String password) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}
