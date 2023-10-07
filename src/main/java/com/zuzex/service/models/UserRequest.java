package com.zuzex.service.models;

import com.sun.istack.NotNull;

public class UserRequest {
    @NotNull
    private String name;
    @NotNull
    private String password;

    public UserRequest() {
    }

    public UserRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
