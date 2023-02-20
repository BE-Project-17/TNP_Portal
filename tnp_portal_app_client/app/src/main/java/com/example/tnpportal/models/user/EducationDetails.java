package com.example.tnpportal.models.user;

public class EducationDetails {

    private Double ssc_marks;
    private Double hsc_marks;
    private Double diploma_marks;
    private Double cgpa;

    public EducationDetails(Double ssc_marks, Double hsc_marks, Double diploma_marks, Double cgpa) {
        this.ssc_marks = ssc_marks;
        this.hsc_marks = hsc_marks;
        this.diploma_marks = diploma_marks;
        this.cgpa = cgpa;
    }

    public Double getSsc_marks() {
        return ssc_marks;
    }

    public Double getHsc_marks() {
        return hsc_marks;
    }

    public Double getDiploma_marks() {
        return diploma_marks;
    }

    public Double getCgpa() {
        return cgpa;
    }
}
