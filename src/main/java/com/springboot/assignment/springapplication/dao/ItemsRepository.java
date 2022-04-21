package com.springboot.assignment.springapplication.dao;

import com.springboot.assignment.springapplication.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ItemsRepository extends JpaRepository<Item,Integer> {

}
