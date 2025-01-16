package com.devpaulojr.springmongo.dto;

import com.devpaulojr.springmongo.model.Post;
import com.devpaulojr.springmongo.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PostDto implements Serializable {

    @Id
    private String id;

    private LocalDate date;
    private String title;
    private String body;

    private User author;

    public PostDto(Post post){
        this.id = post.getId();
        this.date = post.getDate();
        this.title = post.getTitle();
        this.body = post.getBody();
        this.author = post.getAuthor();
    }
}
