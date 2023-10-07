package com.zuzex.web.controllers;

import com.zuzex.jpa.HouseJpaRepository;
import com.zuzex.jpa.UserJpaRepository;
import com.zuzex.service.models.House;
import com.zuzex.service.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainRestController {

    private UserJpaRepository userJpaRepository;
    private HouseJpaRepository houseJpaRepository;


    @Autowired
    MainRestController(UserJpaRepository userJpaRepository, HouseJpaRepository houseJpaRepository) {
        this.userJpaRepository = userJpaRepository;
        this.houseJpaRepository = houseJpaRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userJpaRepository.findAll();
    }

    @GetMapping("/houses")
    public List<House> getAllHouses() {
        return houseJpaRepository.findAll();
    }
}
