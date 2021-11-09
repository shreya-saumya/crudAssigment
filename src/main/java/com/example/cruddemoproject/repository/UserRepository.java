package com.example.cruddemoproject.repository;

import com.example.cruddemoproject.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users,Integer> {

    Users findAllById(long id);

    Users findByNameAndEmail(String name, String email);

    void deleteById(long id);
}
