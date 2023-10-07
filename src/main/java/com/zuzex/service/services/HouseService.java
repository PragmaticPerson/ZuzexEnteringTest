package com.zuzex.service.services;

import com.zuzex.jpa.HouseJpaRepository;
import com.zuzex.service.models.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class HouseService {

    private HouseJpaRepository repository;

    @Autowired
    public HouseService(HouseJpaRepository repository) {
        this.repository = repository;
    }

    public List<House> findAll() {
        var houses = repository.findAll();
        for (House house : houses) {
            house.getInmates().stream().forEach(System.out::println);
        }
        return houses;
    }

    public House findById(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }
}
