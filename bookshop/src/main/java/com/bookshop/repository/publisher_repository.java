package com.bookshop.repository;

import com.bookshop.entity.tb_pbs_publisher;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface publisher_repository extends JpaRepository<tb_pbs_publisher, UUID> {
}
