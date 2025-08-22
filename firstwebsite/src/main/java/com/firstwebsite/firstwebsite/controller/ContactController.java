package com.firstwebsite.firstwebsite.controller;

import com.firstwebsite.firstwebsite.EmailService;
import com.firstwebsite.firstwebsite.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ContactController {

    private final EmailService emailService;

    @Autowired
    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/contact")
    public ResponseEntity<String> submitContact(@RequestBody ContactForm form) {
        System.out.println("Received contact form: " + form.getName() + ", " + form.getEmail() + ", " + form.getMessage());

        // Construct the body of the email
        String subject = "New Contact from " + form.getName();
        String body = "Email: " + form.getEmail() + "\n\nMessage:\n" + form.getMessage();

        // Send to your recipient email
        emailService.sendEmail("alfredz0712@gmail.com", subject, body);  // Replace with your receiving email

        return ResponseEntity.ok("Message received!");
    }
}
