package com.springboot.assignment.springapplication.dao;

import com.springboot.assignment.springapplication.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,String>{

}
