package com.springboot.assignment.springapplication.service;

import com.springboot.assignment.springapplication.dao.UserRepository;
import com.springboot.assignment.springapplication.entity.Customer;
import com.springboot.assignment.springapplication.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

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

    public User findById(String username) {
        Optional<User> result = userRepository.findById(username);
        Logger logger = Logger.getLogger(ItemsServiceImplementation.class.getName());
        User user = null;
        if (result.isPresent()) {
            user = result.get();
        } else {
            logger.info("can not find item with id =" + username);
        }
        return user;
    }
}
