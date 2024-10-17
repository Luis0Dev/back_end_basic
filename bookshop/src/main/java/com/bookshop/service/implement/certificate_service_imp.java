package com.bookshop.service.implement;

import com.bookshop.entity.tb_usr_user_certificate;
import com.bookshop.repository.certificate_repository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class certificate_service_imp{
    @Autowired
    private certificate_repository certificate_repository;
    private aes_encryption_service_imp aes_encryption_service;

    public void store_certificate(String certificate) throws Exception {
        String encrypted_certificate = aes_encryption_service.encrypt(certificate);
        tb_usr_user_certificate usr_certificate= new tb_usr_user_certificate();
        usr_certificate.setUsrc_c_certificate_hash(encrypted_certificate);
        certificate_repository.save(usr_certificate);
    }
}