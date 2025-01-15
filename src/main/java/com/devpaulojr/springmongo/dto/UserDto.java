package com.devpaulojr.springmongo.dto;

import com.devpaulojr.springmongo.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserDto implements Serializable {

    @Id
    private String id;

    private String name;
    private String email;
    private String phone;

    public UserDto(User obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.phone = obj.getPhone();
    }
}
