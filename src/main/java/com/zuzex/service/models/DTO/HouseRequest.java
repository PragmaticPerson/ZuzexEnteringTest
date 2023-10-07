package com.zuzex.service.models.DTO;


public class HouseRequest {
    private int id;
    private String address;
    private int owner;
    private int[] inmates;

    public HouseRequest() {
    }

    public HouseRequest(int id, String address, int owner, int[] inmates) {
        this.id = id;
        this.address = address;
        this.owner = owner;
        this.inmates = inmates;
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

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int[] getInmates() {
        return inmates;
    }

    public void setInmates(int[] inmates) {
        this.inmates = inmates;
    }
}
