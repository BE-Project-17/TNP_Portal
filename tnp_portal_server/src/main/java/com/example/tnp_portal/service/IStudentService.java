package com.example.tnp_portal.service;

import com.example.tnp_portal.entity.Student;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IStudentService {

    public ResponseEntity<?> addStudent(Student student);
    public ResponseEntity<?> getAllStudents();

    public ResponseEntity<?> applyForCompany(ObjectId id, ObjectId job_id);

    public ResponseEntity<?> deleteApplicationForJob(ObjectId id, ObjectId job_id);

    public ResponseEntity<?> updateStudent(ObjectId id, Map<String,?> request);

    public ResponseEntity<?> getAllPlacedStudents();

    public ResponseEntity<?> login(Map<String,?> request);

    public ResponseEntity<?> getAppliedStudents(String id);
}
