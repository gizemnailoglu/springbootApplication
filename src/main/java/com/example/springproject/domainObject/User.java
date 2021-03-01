package com.example.springproject.domainObject;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="userinfo")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;


    @Column(nullable = false , unique = true)
    private  String username;
    private String name ;
    private String password;
    private  String surname ;


//    @OneToOne(cascade = CascadeType.ALL) // etkileşimli olsun istediğimiz için ekledik.
//    @JoinColumn(name = "address_id")
//    private Address address;


}
