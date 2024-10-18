package com.bookshop.controller;

import com.bookshop.entity.tb_usr_user;
import com.bookshop.repository.user_repository;
import com.bookshop.service.implement.certificate_service_imp;
import com.bookshop.service.user_service;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class user_controller {

    private final user_service user_service;
    private final user_repository user_repository;
    private final  BCryptPasswordEncoder password_encoder;
    private final certificate_service_imp certificate_service;

    @Autowired
    public user_controller(user_service user_service, user_repository user_repository, BCryptPasswordEncoder password_encoder, certificate_service_imp certificate_service) {
        this.user_service = user_service;
        this.user_repository = user_repository;
        this.password_encoder = password_encoder;
        this.certificate_service = certificate_service;
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<tb_usr_user> get_user_to_update(@PathVariable UUID id) {
        return user_repository.findById(id)
                .map(user -> ResponseEntity.ok(user))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/update")
    public ResponseEntity<String> perform_update(@RequestBody @Valid tb_usr_user user) {
        try {
            user_repository.save(user);
            return ResponseEntity.ok("User updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user: " + e.getMessage());
        }
    }

    @PostMapping("/api/v1/signup")
    public ResponseEntity<String> signUp(@RequestBody @Valid tb_usr_user user) {
        try {
            String certificate = user.get_usr_usr_c_certificate().toString();
            boolean is_certificate_valid = certificate_service.store_certificate(certificate);
            if (!is_certificate_valid) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid certificate!");
            }

            user_service.saveUser(user, "USER");
            return ResponseEntity.ok("User created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user: " + e.getMessage());
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestParam String username, @RequestParam String password) {
        tb_usr_user user = user_service.findByUsername(username);
        if (user != null && password_encoder.matches(password, user.get_usr_c_password())) {
            return ResponseEntity.ok("User logged in successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password!");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("User successfully logged out!");
    }
}
