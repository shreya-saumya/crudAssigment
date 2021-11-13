package com.example.cruddemoproject.controller;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.example.cruddemoproject.dto.UserDto;
import com.example.cruddemoproject.entity.Users;
import com.example.cruddemoproject.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    @Test
    void testGetAllUsers() throws Exception {
        when(this.userService.getAllUsers()).thenReturn(new ArrayList<Users>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/user");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAllUsers2() throws Exception {
        when(this.userService.getAllUsers()).thenReturn(new ArrayList<Users>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/user");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetUserById() throws Exception {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        when(this.userService.getUserById(anyInt())).thenReturn(users);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/user/{id}", 1);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"address\":\"42 Main St\",\"phone\":1}"));
    }

    @Test
    void testCreateNewUser() throws Exception {
        when(this.userService.getAllUsers()).thenReturn(new ArrayList<Users>());

        UserDto userDto = new UserDto();
        userDto.setEmail("jane.doe@example.org");
        userDto.setPhone(1);
        userDto.setName("Name");
        userDto.setAddress("42 Main St");
        String content = (new ObjectMapper()).writeValueAsString(userDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testDeleteUserById() throws Exception {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        when(this.userService.deleteUserById(anyInt())).thenReturn(users);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/v1/user/{id}", 1);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"address\":\"42 Main St\",\"phone\":1}"));
    }

    @Test
    void testGetUserByNameAndEmail() throws Exception {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        when(this.userService.getUserByNameAndEmail((String) any(), (String) any())).thenReturn(users);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/user/{name}/{email}", "Name",
                "jane.doe@example.org");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"address\":\"42 Main St\",\"phone\":1}"));
    }

    @Test
    void testUpdateUser() throws Exception {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setPhone(1);
        users.setId(123L);
        users.setName("Name");
        users.setAddress("42 Main St");
        when(this.userService.updatedUser(anyInt(), (Users) any())).thenReturn(users);

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setPhone(1);
        users1.setId(123L);
        users1.setName("Name");
        users1.setAddress("42 Main St");
        String content = (new ObjectMapper()).writeValueAsString(users1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/v1/user/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"address\":\"42 Main St\",\"phone\":1}"));
    }
}

