package com.devpaulojr.springmongo.model;

import com.devpaulojr.springmongo.dto.AuthorDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
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

}
