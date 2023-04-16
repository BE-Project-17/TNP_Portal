package com.example.tnp_portal.service;

import com.example.tnp_portal.entity.EmailDetails;

public interface IEmailService {
    String sendEmail(EmailDetails emailDetails);
}
