package com.bookshop.repository;

import com.bookshop.entity.tb_ath_author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface author_repository extends JpaRepository<tb_ath_author, UUID> {
}
