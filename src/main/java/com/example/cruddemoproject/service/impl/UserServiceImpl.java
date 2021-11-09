package com.example.cruddemoproject.service.impl;

import com.example.cruddemoproject.dto.UserDto;
import com.example.cruddemoproject.entity.Users;
import com.example.cruddemoproject.repository.UserRepository;
import com.example.cruddemoproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Users> getAllUsers() {
        return (List<Users>) userRepository.findAll();
    }

    @Override
    public Users getUserById(int id) {
        return  userRepository.findAllById(id);
    }

    @Override
    public Users updatedUser(int id, Users users) {

        Users user =(Users) userRepository.findAllById(id);
        user.setAddress(users.getAddress());
        user.setEmail(users.getEmail());
        user.setPhone(users.getPhone());
        user.setName(users.getName());

        return userRepository.save(user);

    }


    @Override
    public Users deleteUserById(int id) {
        Users deletedUser=null;
        try{
            deletedUser= (Users) userRepository.findAllById(id);
            if(deletedUser==null){
                throw new Exception("User Not Found");
            }
            else{
                userRepository.deleteById(id);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return deletedUser;
    }

    @Override
    public Users createNewUser(UserDto userDto) {

        Users user = new Users();
        user.setAddress(userDto.getAddress());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setName(userDto.getName());

        return userRepository.save(user);
    }

    @Override
    public Users getUserByNameAndEmail(String name, String email) {

        return userRepository.findByNameAndEmail(name,email);
    }

}
