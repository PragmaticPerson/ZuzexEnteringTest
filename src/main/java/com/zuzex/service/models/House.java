package com.zuzex.service.models;

import javax.persistence.*;

@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String address;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    public House() {
    }

    public House(int id, String address, User owner) {
        this.id = id;
        this.address = address;
        this.owner = owner;
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
}
