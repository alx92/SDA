package org.example.service;

@org.springframework.stereotype.Service
public abstract class Service {

    private static final String key = "private key";

    public static String getKey() {
        return key;
    }
}
