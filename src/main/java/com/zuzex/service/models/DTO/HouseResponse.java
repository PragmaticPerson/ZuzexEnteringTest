package com.zuzex.service.models.DTO;

import java.util.HashSet;
import java.util.Set;

public class HouseResponse {

    private int id;
    private String address;
    private UserResponse owner;
    private Set<UserResponse> inmates;

    public HouseResponse() {
    }

    public HouseResponse(int id, String address, UserResponse owner) {
        this.id = id;
        this.address = address;
        this.owner = owner;
        inmates = new HashSet<>();
    }

    public void addInmate(UserResponse user) {
        inmates.add(user);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserResponse getOwner() {
        return owner;
    }

    public void setOwner(UserResponse owner) {
        this.owner = owner;
    }

    public Set<UserResponse> getInmates() {
        return inmates;
    }

    public void setInmates(Set<UserResponse> inmates) {
        this.inmates = inmates;
    }
}
