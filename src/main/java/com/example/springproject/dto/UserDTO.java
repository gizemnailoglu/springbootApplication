package com.example.springproject.dto;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;

import com.example.springproject.domainObject.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO extends User implements Serializable {

    /**
     *
     */

    private static final long serialVersionUID =1L;

    @JsonIgnore
    private String username;
    private String name;
    private String surname;
    private String email;
//    @JsonProperty("role")
//    private Role roleDTO;
//
//    public void setRoleDTO(UserDTO userDTO) {
//    }
}
