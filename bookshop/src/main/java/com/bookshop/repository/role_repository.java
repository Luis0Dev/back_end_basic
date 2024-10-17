package com.bookshop.repository;

import com.bookshop.entity.tb_rol_role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface role_repository extends JpaRepository<tb_rol_role, UUID> {
    tb_rol_role findByName(String name);
}
