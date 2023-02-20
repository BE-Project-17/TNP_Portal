package com.example.tnp_portal.utils;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    BOTH("Both");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
