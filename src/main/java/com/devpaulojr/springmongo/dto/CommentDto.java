package com.devpaulojr.springmongo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {

    private String text;
    private LocalDate date;
    private AuthorDto author;

    public CommentDto(String text, LocalDate date, AuthorDto author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

}
