package com.example.tnp_portal.entity;

import com.example.tnp_portal.utils.Branch;
import com.example.tnp_portal.utils.Gender;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;


@Document(collection = "jobs")
public class Job implements Serializable {

    @Id
    @Field("_id")
    private ObjectId id;

    private String role;
    private Long ctc;
    private String registration_end_date_time;
    private Float ssc;
    private Float hsc;
    private Float cgpa;
    private List<String> skills;
    private List<Branch> ugBranch;
    private List<Branch> pgBranch;
    private Gender gender;

    @DBRef
    private Company company;

    public Job() {
    }

    public Job(String role, Long ctc, String registration_end_date_time, Float ssc, Float hsc, Float cgpa, List<String> skills, List<Branch> ugBranch, List<Branch> pgBranch, Gender gender) {
        this.role = role;
        this.ctc = ctc;
        this.registration_end_date_time = registration_end_date_time;
        this.ssc = ssc;
        this.hsc = hsc;
        this.cgpa = cgpa;
        this.skills = skills;
        this.ugBranch = ugBranch;
        this.pgBranch = pgBranch;
        this.gender = gender;
    }

    public String getId() {
        return String.valueOf(id);
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getCtc() {
        return ctc;
    }

    public void setCtc(Long ctc) {
        this.ctc = ctc;
    }

    public String getRegistration_end_date_time() {
        return registration_end_date_time;
    }

    public void setRegistration_end_date_time(String registration_end_date_time) {
        this.registration_end_date_time = registration_end_date_time;
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

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<Branch> getUgBranch() {
        return ugBranch;
    }

    public void setUgBranch(List<Branch> ugBranch) {
        this.ugBranch = ugBranch;
    }

    public List<Branch> getPgBranch() {
        return pgBranch;
    }

    public void setPgBranch(List<Branch> pgBranch) {
        this.pgBranch = pgBranch;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", description='" + role + '\'' +
                ", ctc=" + ctc +
                ", registration_end_date_time='" + registration_end_date_time + '\'' +
                ", ssc=" + ssc +
                ", hsc=" + hsc +
                ", cgpa=" + cgpa +
                ", skills='" + skills + '\'' +
                ", ugBranch=" + ugBranch +
                ", pgBranch=" + pgBranch +
                ", gender=" + gender +
                ", company=" + company +
                '}';
    }
}
