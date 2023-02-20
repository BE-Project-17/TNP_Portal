package com.example.tnp_portal.service;

import com.example.tnp_portal.entity.Company;
import com.example.tnp_portal.entity.Job;
import com.example.tnp_portal.repository.ICompanyRepository;
import com.example.tnp_portal.repository.IJobRepository;
import com.example.tnp_portal.utils.Gender;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class JobServiceImpl implements IJobService{

    @Autowired
    private IJobRepository repository;

    @Autowired
    private ICompanyRepository companyRepository;


    @Override
    public ResponseEntity<?> getAllJobs() {
        try {
            List<Job> jobs = repository.findAll();
            return new ResponseEntity<>(jobs, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getJobForCompany(ObjectId company_id) {
        try {
            Optional<Company> company = companyRepository.findById(company_id);
            if(company.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Optional<Job> job = repository.getJobForCompany(company_id);
            return new ResponseEntity<>(job,HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteJobById(ObjectId id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updateJobById(ObjectId id, Map<String, ?> request) {
        try{
            Optional<Job> job = repository.findById(id);
            if(job.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            if(request.containsKey("role")){
                job.get().setRole(request.get("role").toString());
            }
            if(request.containsKey("ctc")){
                job.get().setCtc(Long.valueOf(request.get("ctc").toString()));
            }
            if(request.containsKey("registration_end_date_time")){
                job.get().setRegistration_end_date_time(request.get("registration_end_date_time").toString());
            }
            if(request.containsKey("ssc")){
                job.get().setSsc(Float.valueOf(request.get("ssc").toString()));
            }
            if(request.containsKey("hsc")){
                job.get().setHsc(Float.valueOf(request.get("hsc").toString()));
            }
            if(request.containsKey("cgpa")){
                job.get().setCgpa(Float.valueOf(request.get("cgpa").toString()));
            }
            if(request.containsKey("skills")){
                job.get().setSkills(List.of(request.get("skills").toString()));
            }
            // TODO: For UG and PG Branches
            if(request.containsKey("gender")){
                job.get().setGender(Gender.valueOf(request.get("gender").toString()));
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
