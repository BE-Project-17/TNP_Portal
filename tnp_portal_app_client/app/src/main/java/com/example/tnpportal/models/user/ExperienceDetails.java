package com.example.tnpportal.models.user;

public class ExperienceDetails {

    private Long internships;
    private Long projects;
    private Long backlogs;

    public ExperienceDetails(Long internships, Long projects, Long backlogs) {
        this.internships = internships;
        this.projects = projects;
        this.backlogs = backlogs;
    }

    public Long getInternships() {
        return internships;
    }

    public Long getProjects() {
        return projects;
    }

    public Long getBacklogs() {
        return backlogs;
    }
}
