package com.springboot.assignment.springapplication.service;

import com.springboot.assignment.springapplication.dao.UserRepository;
import com.springboot.assignment.springapplication.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void save(){
        User user = new User("avinash","test123");
        userService.save(user);
        when(userRepository.save(user)).thenReturn(user);
        User returnUser = new User("avinash","test123");
        assertEquals(user, returnUser);
    }
}
