package com.zuzex.service.models;

public class UserResponce {
    private String name;
    private String accessToken;

    public UserResponce() {
    }

    public UserResponce(String name, String accessToken) {
        this.name = name;
        this.accessToken = accessToken;
    }

    public String getName() {
        return name;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
