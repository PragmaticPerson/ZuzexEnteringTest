package com.zuzex.web.controllers;

import com.zuzex.service.models.DTO.HouseRequest;
import com.zuzex.service.models.DTO.HouseResponse;
import com.zuzex.service.models.House;
import com.zuzex.service.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/houses")
public class HouseRestController {

    private HouseService service;

    @Autowired
    public HouseRestController(HouseService service) {
        this.service = service;
    }

    @GetMapping()
    public List<HouseResponse> getAllHouses() {
        var houses = service.findAll();
        return houses.stream().map(House::toHouseResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public HouseResponse getCurrentHouse(@PathVariable int id) {
        return service.findById(id).toHouseResponse();
    }

    @PostMapping()
    public HouseResponse addNewHouse(@RequestBody HouseRequest request) {
        return service.save(request).toHouseResponse();
    }

    @PutMapping("/{id}")
    public HouseResponse editCurrentHouse(@PathVariable int id, @RequestBody HouseRequest request) {
        request.setId(id);
        return service.edit(request).toHouseResponse();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCurrentHouse(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
