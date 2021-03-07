package com.example.springproject.domainObject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(nullable = false , unique = true)

    private String header ;
    private String description;


    private String username;
    private Long userId ;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate= new Date(System.currentTimeMillis());


















}
