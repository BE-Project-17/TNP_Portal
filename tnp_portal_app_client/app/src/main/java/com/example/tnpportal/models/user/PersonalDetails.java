package com.example.tnpportal.models.user;

public class PersonalDetails {

    private String email;
    private Long phoneNo;
    private String gender;

    public PersonalDetails(String email, Long phoneNo, String gender) {
        this.email = email;
        this.phoneNo = phoneNo;
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public String getGender() {
        return gender;
    }
}
