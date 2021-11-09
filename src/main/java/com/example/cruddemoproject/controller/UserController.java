package com.example.cruddemoproject.controller;

import com.example.cruddemoproject.dto.UserDto;
import com.example.cruddemoproject.entity.Users;
import com.example.cruddemoproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List <Users> users =null;
        try{
            users = userService.getAllUsers();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<List<Users>>(users,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") int id) {
        Users user =null;
        try{
            user = userService.getUserById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Users> createNewUser(@RequestBody UserDto userDto) {
        Users users =null;
        try{
            users = userService.createNewUser(userDto);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Users> updateUser(@PathVariable("id") int id,@RequestBody Users userDto ){
        Users users =null;
        try{
            users = userService.updatedUser(id,userDto);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUserById(@PathVariable("id") int id) {
        Users users =null;
        try{
            users = userService.deleteUserById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{name}/{email}")
    public ResponseEntity<Users> getUserByNameAndEmail(@PathVariable("name") String name ,@PathVariable("email") String email) {
        Users user =null;
        try{
            user = userService.getUserByNameAndEmail(name,email);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(user);
    }


}
