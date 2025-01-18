package com.devpaulojr.springmongo.model;

import com.devpaulojr.springmongo.dto.AuthorDto;
import com.devpaulojr.springmongo.dto.CommentDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "post")
public class Post implements Serializable {

    @Id
    private String id;

    private LocalDate date;
    private String title;
    private String body;

    private AuthorDto author;

    private List<CommentDto> comments = new ArrayList<>();

    public Post(String id, LocalDate date, String title, String body, AuthorDto author) {
        super();
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
