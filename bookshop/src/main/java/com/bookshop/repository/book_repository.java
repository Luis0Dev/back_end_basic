package com.bookshop.repository;

import com.bookshop.entity.tb_bok_book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface book_repository extends JpaRepository<tb_bok_book, UUID> {
}
