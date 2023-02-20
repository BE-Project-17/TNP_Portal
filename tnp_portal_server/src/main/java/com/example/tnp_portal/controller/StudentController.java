package com.example.tnp_portal.controller;

import com.example.tnp_portal.entity.Student;
import com.example.tnp_portal.service.StudentServiceImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/student")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {

    private StudentServiceImpl service;

    @Autowired
    public StudentController(StudentServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody Student body){
        return this.service.addStudent(body);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllUsers(){
        return this.service.getAllStudents();
    }

    @PutMapping("/apply-company/{id}/{job_id}")
    public ResponseEntity<?> applyForCompany(@PathVariable(name = "id") ObjectId id, @PathVariable(name = "job_id") ObjectId job_id){
        return this.service.applyForCompany(id,job_id);
    }

    @DeleteMapping("/delete-job/{id}/{job_id}")
    public ResponseEntity<?> deleteApplicationForJob(@PathVariable(name = "id") ObjectId id, @PathVariable(name = "job_id") ObjectId job_id){
        return this.service.deleteApplicationForJob(id,job_id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable(name = "id") ObjectId id, @RequestBody Map<String,?> body){
        return this.service.updateStudent(id,body);
    }

    @GetMapping("/placed")
    public ResponseEntity<?> getAllPlacedStudents(){
        return this.service.getAllPlacedStudents();
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginStudent(@RequestBody Map<String,?> body){
        return this.service.login(body);
    }
}
