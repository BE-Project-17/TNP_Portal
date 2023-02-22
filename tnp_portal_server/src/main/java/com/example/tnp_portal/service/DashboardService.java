package com.example.tnp_portal.service;

import com.example.tnp_portal.entity.Student;
import com.example.tnp_portal.repository.ICompanyRepository;
import com.example.tnp_portal.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DashboardService implements IDashboardService{

    @Autowired
    private IStudentRepository repository;
    @Autowired
    private ICompanyRepository companyRepository;

    @Override
    public ResponseEntity<?> getBasicDetails() {
        try{
            Optional<List<Student>> placedStudents = repository.findPlacedStudents(true);
            Optional<List<Student>> unplacedStudents = repository.findPlacedStudents(false);
            int noOfCompanies = companyRepository.findAll().size();
            Map<String,Object> result = new HashMap<>();
            result.put("noOfCompanies",noOfCompanies);
            result.put("noOfPlacedStudents",placedStudents.get().size());
            result.put("noOfUnplacedStudents",unplacedStudents.get().size());

            return new ResponseEntity<>(result, HttpStatus.OK);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
