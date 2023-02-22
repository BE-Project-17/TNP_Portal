package com.example.tnp_portal.service;

import com.example.tnp_portal.entity.Admin;
import com.example.tnp_portal.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class AdminService implements IAdminService{

    @Autowired
    private IAdminRepository repository;
    @Override
    public ResponseEntity<?> addAdmin(Admin admin) {
        try{
            repository.save(admin);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> login(Map<String, String> request) {
        try{
            if(!request.containsKey("username") || !request.containsKey("password")){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Optional<Admin> admin = repository.getAdminByUsername(request.get("username"));
            if(admin.isEmpty()){
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
            if(admin.get().getPassword().equals(request.get("password"))){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
