package com.example.tnpportal.models.user;

public class CollegeDetails {
    private String name;
    private Long roll_no;
    private String registration_id;
    private String branch;

    public CollegeDetails(String name, Long roll_no, String registration_id, String branch) {
        this.name = name;
        this.roll_no = roll_no;
        this.registration_id = registration_id;
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public Long getRoll_no() {
        return roll_no;
    }

    public String getRegistration_id() {
        return registration_id;
    }

    public String getBranch() {
        return branch;
    }
}
