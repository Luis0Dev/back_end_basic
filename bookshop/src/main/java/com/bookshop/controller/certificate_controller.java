package com.bookshop.controller;

import com.bookshop.service.implement.certificate_service_imp;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.cert.Certificate;

@RestController
@RequestMapping("/api/v1/certificate")
public class certificate_controller{
    @Autowired
    certificate_service_imp certificate_service;

    public String store_certificate(@RequestBody String certificate){
        try{
            certificate_service.store_certificate(certificate);
            return "Certificate stored successfully!";
        }catch(Exception e){
            return "Certificate could not be stored:" + e.getMessage();
        }
    }
}
