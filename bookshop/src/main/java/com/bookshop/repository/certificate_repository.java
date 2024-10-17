package com.bookshop.repository;

import com.bookshop.entity.tb_usr_user_certificate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface certificate_repository extends JpaRepository<tb_usr_user_certificate, UUID> {
}
