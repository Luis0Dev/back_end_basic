package com.bookshop.repository;

import com.bookshop.entity.tb_usr_user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface user_repository extends JpaRepository<tb_usr_user, UUID> {
    tb_usr_user findByUsername(String username);
}
