package com.example.cruddemoproject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private  String address;

    @Column
    private Integer phone;

}
