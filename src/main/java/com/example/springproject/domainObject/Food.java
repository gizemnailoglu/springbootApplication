package com.example.springproject.domainObject;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private Long userId ;

    @CreatedDate
    private LocalDateTime createdDate ;

    @LastModifiedDate
    private  LocalDateTime modifiedDate ;















}
