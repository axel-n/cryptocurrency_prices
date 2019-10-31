package com.example.prices.models;

import lombok.Data;

import java.util.Date;

@Data
public class AuthPayload {
    private String path;
    private Long timestamp;
    private Long tokenId;

    public AuthPayload(String path,  Long tokenId) {
        this.path = path;
        this.tokenId = tokenId;
        this.timestamp = new Date().getTime();
    }
}
