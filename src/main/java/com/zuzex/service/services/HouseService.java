package com.zuzex.service.services;

import com.zuzex.jpa.HouseJpaRepository;
import com.zuzex.service.models.DTO.HouseRequest;
import com.zuzex.service.models.House;
import com.zuzex.service.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;

@Component
public class HouseService {

    private HouseJpaRepository repository;
    private UserService userService;

    @Autowired
    public HouseService(HouseJpaRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public List<House> findAll() {
        var houses = repository.findAll();
        for (House house : houses) {
            house.getInmates().forEach(System.out::println);
        }
        return houses;
    }

    public House findById(int id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public House save(HouseRequest request) {
        var house = new House();
        house.setAddress(request.getAddress());
        house.setOwner(userService.getUserById(request.getOwner()));

        var inmates = new HashSet<User>();
        for (int inmate : request.getInmates()) {
            inmates.add(userService.getUserById(inmate));
        }
        house.setInmates(inmates);

        return repository.save(house);
    }
}
