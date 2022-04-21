package com.springboot.assignment.springapplication.service;

import com.springboot.assignment.springapplication.dao.UserRepository;
import com.springboot.assignment.springapplication.entity.Item;
import com.springboot.assignment.springapplication.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{

    UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
