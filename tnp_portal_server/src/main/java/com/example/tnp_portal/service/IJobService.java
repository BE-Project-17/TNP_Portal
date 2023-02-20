package com.example.tnp_portal.service;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IJobService {
    public ResponseEntity<?> getAllJobs();
    public ResponseEntity<?> getJobForCompany(ObjectId company_id);

    public ResponseEntity<?> deleteJobById(ObjectId id);

    public ResponseEntity<?> updateJobById(ObjectId id, Map<String,?> request);
}
