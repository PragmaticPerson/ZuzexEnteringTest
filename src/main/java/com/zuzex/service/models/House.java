package com.zuzex.service.models;

import com.zuzex.service.models.DTO.HouseResponse;

import javax.persistence.*;
import java.util.Set;

@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "inmates",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "house_id", referencedColumnName = "id")
    )
    private Set<User> inmates;

    public House() {
    }

    public House(int id, String address, User owner, Set<User> inmates) {
        this.id = id;
        this.address = address;
        this.owner = owner;
        this.inmates = inmates;
    }

    public HouseResponse toHouseResponse() {
        var response = new HouseResponse(id, address, owner.toUserResponse());
        inmates.stream().forEach(user -> response.addInmate(user.toUserResponse()));
        return response;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<User> getInmates() {
        return inmates;
    }

    public void setInmates(Set<User> inmates) {
        this.inmates = inmates;
    }
}