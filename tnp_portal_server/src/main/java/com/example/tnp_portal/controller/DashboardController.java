package com.example.tnp_portal.controller;

import com.example.tnp_portal.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/dashboard")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DashboardController {

    private final DashboardService service;

    @Autowired
    public DashboardController(DashboardService service) {
        this.service = service;
    }

    @GetMapping("/info")
    public ResponseEntity<?> getBasicDetails(){
        return this.service.getBasicDetails();
    }

}
