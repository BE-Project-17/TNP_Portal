package com.example.tnp_portal.service;

import com.example.tnp_portal.entity.Company;
import com.example.tnp_portal.entity.Job;
import com.example.tnp_portal.repository.ICompanyRepository;
import com.example.tnp_portal.repository.IJobRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements ICompanyService{

    @Autowired
    private ICompanyRepository repository;
    @Autowired
    private IJobRepository jobRepository;

    @Override
    public ResponseEntity<?> addCompany(Company company) {
        try {
            repository.save(company);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAllCompany() {
        try {
            List<Company> companyList = repository.findAll();
            return new ResponseEntity<>(companyList, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> addJobToCompany(ObjectId id, Job job) {
        try{
            Optional<Company> company = repository.findById(id);
            if(company.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            job.setCompany(company.get());
            jobRepository.save(job);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updateCompanyById(ObjectId id, Map<String,?> request) {
        try{
            Optional<Company> company = repository.findById(id);
            if(company.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            if(request.containsKey("name")){
                company.get().setName(request.get("name").toString());
            }
            if(request.containsKey("email")){
                company.get().setEmail(request.get("email").toString());
            }
            if(request.containsKey("url")){
                company.get().setUrl(request.get("url").toString());
            }
            if(request.containsKey("address")){
                company.get().setAddress(request.get("address").toString());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
