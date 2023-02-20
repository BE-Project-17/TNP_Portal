package com.example.tnp_portal.entity;

import com.example.tnp_portal.utils.Branch;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Document(collection = "students")
public class Student implements Serializable {
    @Id
    @Field("_id")
    private ObjectId id;

    private String name;
    private String email;

    private Branch branch;
    private String password;
    private Long rollNo;
    private Float cgpa;
    private Float ssc;
    private Float hsc;
    private Float quantitative_score;
    private Float logical_reasoning_score;
    private Float english_prof_score;
    private Float automata_pro_score;
    private Float computer_science_score;
    private Integer internships;
    private Integer backlogs;
    private Integer projects;
    private boolean isPlaced;

    @DBRef
    private List<Job> appliedJobs;

    public Student() {
    }

    public Student(String name,String email,Branch branch, String password, Long rollNo, Float cgpa, Float ssc, Float hsc, Float quantitative_score, Float logical_reasoning_score, Float english_prof_score, Float automata_pro_score, Float computer_science_score, Integer internships, Integer backlogs, Integer projects, boolean isPlaced) {
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.password = password;
        this.rollNo = rollNo;
        this.cgpa = cgpa;
        this.ssc = ssc;
        this.hsc = hsc;
        this.quantitative_score = quantitative_score;
        this.logical_reasoning_score = logical_reasoning_score;
        this.english_prof_score = english_prof_score;
        this.automata_pro_score = automata_pro_score;
        this.computer_science_score = computer_science_score;
        this.internships = internships;
        this.backlogs = backlogs;
        this.projects = projects;
        this.isPlaced = isPlaced;
    }

    public String getId() {
        return String.valueOf(id);
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRollNo() {
        return rollNo;
    }

    public void setRollNo(Long rollNo) {
        this.rollNo = rollNo;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public Float getSsc() {
        return ssc;
    }

    public void setSsc(Float ssc) {
        this.ssc = ssc;
    }

    public Float getHsc() {
        return hsc;
    }

    public void setHsc(Float hsc) {
        this.hsc = hsc;
    }

    public Float getQuantitative_score() {
        return quantitative_score;
    }

    public void setQuantitative_score(Float quantitative_score) {
        this.quantitative_score = quantitative_score;
    }

    public Float getLogical_reasoning_score() {
        return logical_reasoning_score;
    }

    public void setLogical_reasoning_score(Float logical_reasoning_score) {
        this.logical_reasoning_score = logical_reasoning_score;
    }

    public Float getEnglish_prof_score() {
        return english_prof_score;
    }

    public void setEnglish_prof_score(Float english_prof_score) {
        this.english_prof_score = english_prof_score;
    }

    public Float getAutomata_pro_score() {
        return automata_pro_score;
    }

    public void setAutomata_pro_score(Float automata_pro_score) {
        this.automata_pro_score = automata_pro_score;
    }

    public Float getComputer_science_score() {
        return computer_science_score;
    }

    public void setComputer_science_score(Float computer_science_score) {
        this.computer_science_score = computer_science_score;
    }

    public Integer getInternships() {
        return internships;
    }

    public void setInternships(Integer internships) {
        this.internships = internships;
    }

    public Integer getBacklogs() {
        return backlogs;
    }

    public void setBacklogs(Integer backlogs) {
        this.backlogs = backlogs;
    }

    public Integer getProjects() {
        return projects;
    }

    public void setProjects(Integer projects) {
        this.projects = projects;
    }

    public boolean getPlaced() {
        return isPlaced;
    }

    public void setPlaced(boolean placed) {
        isPlaced = placed;
    }

    public List<Job> getAppliedJobs() {
        return appliedJobs;
    }

    public void setAppliedJobs(List<Job> appliedJobs) {
        this.appliedJobs = appliedJobs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
