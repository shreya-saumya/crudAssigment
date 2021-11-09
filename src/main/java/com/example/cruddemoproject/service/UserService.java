package com.example.cruddemoproject.service;

import com.example.cruddemoproject.dto.UserDto;
import com.example.cruddemoproject.entity.Users;

import java.util.List;

public interface UserService {

    public List<Users> getAllUsers();
    public Users getUserById(int id);
    public Users updatedUser(int id,Users users);
    public Users deleteUserById(int id);
    public Users createNewUser(UserDto users);
    public Users getUserByNameAndEmail(String name,String email);

}
