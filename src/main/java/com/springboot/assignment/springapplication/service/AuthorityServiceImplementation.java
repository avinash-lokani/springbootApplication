package com.springboot.assignment.springapplication.service;

import com.springboot.assignment.springapplication.dao.AuthorityRepository;
import com.springboot.assignment.springapplication.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthorityServiceImplementation implements AuthorityService{


    AuthorityRepository authorityRepository;

    public AuthorityServiceImplementation(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Transactional
    @Override
    public void save(Authority authority) {
        authorityRepository.save(authority);
    }
}
