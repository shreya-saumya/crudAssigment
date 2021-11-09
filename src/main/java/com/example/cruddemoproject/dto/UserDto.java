package com.example.cruddemoproject.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDto {

    private String name;

    private String email;

    private  String address;

    private Integer phone;

}
