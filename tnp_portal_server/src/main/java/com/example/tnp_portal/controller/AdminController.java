package com.example.tnp_portal.controller;

import com.example.tnp_portal.entity.Admin;
import com.example.tnp_portal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAdmin(@RequestBody Admin admin){
        return this.adminService.addAdmin(admin);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> request){
        return this.adminService.login(request);
    }
}
