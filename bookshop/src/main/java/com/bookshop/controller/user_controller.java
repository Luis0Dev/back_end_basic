package com.bookshop.controller;

import com.bookshop.entity.tb_usr_user;
import com.bookshop.repository.user_repository;
import com.bookshop.service.implement.certificate_service_imp;
import com.bookshop.service.user_service;

import jakarta.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class user_controller {
    private final user_service user_service;
    private final user_repository user_repository;
    private BCryptPasswordEncoder password_encoder;
    private certificate_service_imp certificate_service;

    public user_controller(user_service user_service, user_repository user_repository) {
        this.user_service = user_service;
        this.user_repository = user_repository;
    }
    @GetMapping("/api/v1/update/{id}")
    public String update_author(Model model, @PathVariable UUID id) {
        model.addAttribute("user", user_repository.findById(id));
        return "/api/v1/user/update";
    }

    @PostMapping("/api/v1/update")
    public String perform_update(@ModelAttribute @Valid tb_usr_user user, BindingResult result) {
        if (result.hasErrors()) {
            return "/api/v1/user/update";
        }
        user_repository.save(user);
        return "redirect:/api/v1/user/show_user";

    }
    @PostMapping("/signin")
    public String signIn(@RequestBody @Valid tb_usr_user user) {
        try {
            if (!certificate_service.store_certificate(user.get_usr_usr_c_certificate())); {
                return "Certificado inválido!";
            }
            try {
                user_service.saveUser(user, "USER");
                return "Usuário criado com sucesso!";
            } catch (Exception e) {
                return "Erro ao criar o usuário: " + e.getMessage();
            }
        }
    }
    @PostMapping("/api/v1/signup")
    public String sign_up(@RequestParam String username, @RequestParam String password) {
        tb_usr_user user = user_service.findByUsername(username);
        if (user != null && password_encoder.matches(password, user.get_usr_c_password())) {
            return "User logged in successfully!";
        } else {
            return "Incorrect username or password!";
        }
    }
    @PostMapping("/api/v1/logout")
    public String logout() {
        return "User successfully logged out!";
    }
}
