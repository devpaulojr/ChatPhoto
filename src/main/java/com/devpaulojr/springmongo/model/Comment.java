package com.devpaulojr.springmongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Comment implements Serializable {

    @Id
    private String id;

    private String text;
    private LocalDate date;

    private Post post;
}
