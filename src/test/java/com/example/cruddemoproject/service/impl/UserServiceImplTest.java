package com.example.cruddemoproject.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.cruddemoproject.dto.UserDto;
import com.example.cruddemoproject.entity.Users;
import com.example.cruddemoproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;


    @Test
    void testGetUserById() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        when(this.userRepository.findAllById(anyLong())).thenReturn(users);
        assertSame(users, this.userServiceImpl.getUserById(1));
        verify(this.userRepository).findAllById(anyLong());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testGetUserById2() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        when(this.userRepository.findAllById(anyLong())).thenReturn(users);
        assertSame(users, this.userServiceImpl.getUserById(1));
        verify(this.userRepository).findAllById(anyLong());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testGetUserById3() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        when(this.userRepository.findAllById(anyLong())).thenReturn(users);
        assertSame(users, this.userServiceImpl.getUserById(1));
        verify(this.userRepository).findAllById(anyLong());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testUpdatedUser() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        when(this.userRepository.save((Users) any())).thenReturn(users1);
        when(this.userRepository.findAllById(anyLong())).thenReturn(users);

        Users users2 = new Users();
        users2.setEmail("jane.doe@example.org");
        users2.setPhone(1);
        users2.setId(123L);
        users2.setName("Name");
        users2.setAddress("42 Main St");
        assertSame(users1, this.userServiceImpl.updatedUser(1, users2));
        verify(this.userRepository).findAllById(anyLong());
        verify(this.userRepository).save((Users) any());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testUpdatedUser2() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        when(this.userRepository.save((Users) any())).thenReturn(users1);
        when(this.userRepository.findAllById(anyLong())).thenReturn(users);

        Users users2 = new Users();
        users2.setEmail("jane.doe@example.org");
        users2.setPhone(1);
        users2.setId(123L);
        users2.setName("Name");
        users2.setAddress("42 Main St");
        assertSame(users1, this.userServiceImpl.updatedUser(1, users2));
        verify(this.userRepository).findAllById(anyLong());
        verify(this.userRepository).save((Users) any());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testUpdatedUser3() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        when(this.userRepository.save((Users) any())).thenReturn(users1);
        when(this.userRepository.findAllById(anyLong())).thenReturn(users);

        Users users2 = new Users();
        users2.setEmail("jane.doe@example.org");
        users2.setPhone(1);
        users2.setId(123L);
        users2.setName("Name");
        users2.setAddress("42 Main St");
        assertSame(users1, this.userServiceImpl.updatedUser(1, users2));
        verify(this.userRepository).findAllById(anyLong());
        verify(this.userRepository).save((Users) any());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testDeleteUserById() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        doNothing().when(this.userRepository).deleteById(anyLong());
        when(this.userRepository.findAllById(anyLong())).thenReturn(users);
        assertSame(users, this.userServiceImpl.deleteUserById(1));
        verify(this.userRepository).deleteById(anyLong());
        verify(this.userRepository).findAllById(anyLong());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testDeleteUserById2() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        doNothing().when(this.userRepository).deleteById(anyLong());
        when(this.userRepository.findAllById(anyLong())).thenReturn(users);
        assertSame(users, this.userServiceImpl.deleteUserById(1));
        verify(this.userRepository).deleteById(anyLong());
        verify(this.userRepository).findAllById(anyLong());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testDeleteUserById3() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        doNothing().when(this.userRepository).deleteById(anyLong());
        when(this.userRepository.findAllById(anyLong())).thenReturn(users);
        assertSame(users, this.userServiceImpl.deleteUserById(1));
        verify(this.userRepository).deleteById(anyLong());
        verify(this.userRepository).findAllById(anyLong());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testCreateNewUser() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        when(this.userRepository.save((Users) any())).thenReturn(users);

        UserDto userDto = new UserDto();
        userDto.setEmail("jane.doe@example.org");
        userDto.setPhone(1);
        userDto.setName("Name");
        userDto.setAddress("42 Main St");
        assertSame(users, this.userServiceImpl.createNewUser(userDto));
        verify(this.userRepository).save((Users) any());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testCreateNewUser2() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        when(this.userRepository.save((Users) any())).thenReturn(users);

        UserDto userDto = new UserDto();
        userDto.setEmail("jane.doe@example.org");
        userDto.setPhone(1);
        userDto.setName("Name");
        userDto.setAddress("42 Main St");
        assertSame(users, this.userServiceImpl.createNewUser(userDto));
        verify(this.userRepository).save((Users) any());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testCreateNewUser3() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        when(this.userRepository.save((Users) any())).thenReturn(users);

        UserDto userDto = new UserDto();
        userDto.setEmail("jane.doe@example.org");
        userDto.setPhone(1);
        userDto.setName("Name");
        userDto.setAddress("42 Main St");
        assertSame(users, this.userServiceImpl.createNewUser(userDto));
        verify(this.userRepository).save((Users) any());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testGetUserByNameAndEmail() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        when(this.userRepository.findByNameAndEmail((String) any(), (String) any())).thenReturn(users);
        assertSame(users, this.userServiceImpl.getUserByNameAndEmail("Name", "jane.doe@example.org"));
        verify(this.userRepository).findByNameAndEmail((String) any(), (String) any());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testGetUserByNameAndEmail2() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        when(this.userRepository.findByNameAndEmail((String) any(), (String) any())).thenReturn(users);
        assertSame(users, this.userServiceImpl.getUserByNameAndEmail("Name", "jane.doe@example.org"));
        verify(this.userRepository).findByNameAndEmail((String) any(), (String) any());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testGetUserByNameAndEmail3() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        when(this.userRepository.findByNameAndEmail((String) any(), (String) any())).thenReturn(users);
        assertSame(users, this.userServiceImpl.getUserByNameAndEmail("Name", "jane.doe@example.org"));
        verify(this.userRepository).findByNameAndEmail((String) any(), (String) any());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }
}

