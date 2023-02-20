package com.example.tnp_portal.service;

import com.example.tnp_portal.entity.Company;
import com.example.tnp_portal.entity.Job;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ICompanyService {
    public ResponseEntity<?> addCompany(Company company);
    public ResponseEntity<?> getAllCompany();
    public ResponseEntity<?> addJobToCompany(ObjectId id, Job job);
    public ResponseEntity<?> updateCompanyById(ObjectId id, Map<String,?> request);
}
