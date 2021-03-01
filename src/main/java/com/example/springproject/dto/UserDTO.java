package com.example.springproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {


    /**
     *
     */

    private static final long serialVersionUID =1L;

    @JsonIgnore
    private String username;
    private String name;
    private String surname;
//    @JsonProperty("address")
//    private AddressDTO addressDTO;

}
