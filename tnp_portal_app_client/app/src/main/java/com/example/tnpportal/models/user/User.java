package com.example.tnpportal.models.user;

public class User {

    private CollegeDetails collegeDetails;
    private PersonalDetails personalDetails;
    private EducationDetails educationDetails;
    private AmCatDetails amCatDetails;
    private ExperienceDetails experienceDetails;

    public User(CollegeDetails collegeDetails, PersonalDetails personalDetails, EducationDetails educationDetails, AmCatDetails amCatDetails, ExperienceDetails experienceDetails) {
        this.collegeDetails = collegeDetails;
        this.personalDetails = personalDetails;
        this.educationDetails = educationDetails;
        this.amCatDetails = amCatDetails;
        this.experienceDetails = experienceDetails;
    }

    public CollegeDetails getCollegeDetails() {
        return collegeDetails;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public EducationDetails getEducationDetails() {
        return educationDetails;
    }

    public AmCatDetails getAmCatDetails() {
        return amCatDetails;
    }

    public ExperienceDetails getExperienceDetails() {
        return experienceDetails;
    }
}
