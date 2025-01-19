package com.devpaulojr.springmongo.dto;

import com.devpaulojr.springmongo.model.Comment;
import com.devpaulojr.springmongo.model.Post;
import com.devpaulojr.springmongo.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {

    @Id
    private String id;

    private String text;
    private LocalDate date;

    @JsonIgnore
    private Integer codeComment;

    private PostDto post;

    private AuthorDto author;

    public CommentDto(Comment comment) {
        this.id = comment.getId();
        this.text = comment.getText();
        this.date = comment.getDate();
        this.post = comment.getPost();
        this.author = comment.getAuthor();
    }

}
