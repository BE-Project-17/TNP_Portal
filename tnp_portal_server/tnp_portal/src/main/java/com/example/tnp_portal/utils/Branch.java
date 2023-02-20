package com.example.tnp_portal.utils;

public enum Branch {
    COMPUTER_ENGINEERING("Computer Engineering"),
    INFORMATION_TECHNOLOGY("Information Technology"),
    EnTC("Electronics and Telecommunication");
    private final String value;

    Branch(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
