package com.example.tnp_portal.controller;

import com.example.tnp_portal.entity.Company;
import com.example.tnp_portal.entity.Job;
import com.example.tnp_portal.service.CompanyService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/company")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompanyController {

    private CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCompany(@RequestBody Company body){
        return this.service.addCompany(body);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCompanies(){
        return this.service.getAllCompany();
    }

    @PutMapping("/add-job/{id}")
    public ResponseEntity<?> addJob(@PathVariable(name = "id") ObjectId id, @RequestBody Job body){
        return this.service.addJobToCompany(id,body);
    }

    @PutMapping("")
    public ResponseEntity<?> updateCompany(@PathVariable(name = "id") ObjectId id, @RequestBody Map<String,?> body){
        return this.service.updateCompanyById(id,body);
    }
}
