package com.zuzex.service.models.DTO;

public class UserTokenResponse {
    private String name;
    private String accessToken;

    public UserTokenResponse() {
    }

    public UserTokenResponse(String name, String accessToken) {
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
