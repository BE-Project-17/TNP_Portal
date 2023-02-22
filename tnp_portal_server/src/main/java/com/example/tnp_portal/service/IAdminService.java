package com.example.tnp_portal.service;

import com.example.tnp_portal.entity.Admin;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IAdminService {
    public ResponseEntity<?> addAdmin(Admin admin);
    public ResponseEntity<?> login(Map<String,String> request);
}
