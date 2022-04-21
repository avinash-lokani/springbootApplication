package com.springboot.assignment.springapplication.service;

import com.springboot.assignment.springapplication.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityService{
    void save(Authority authority);
}
