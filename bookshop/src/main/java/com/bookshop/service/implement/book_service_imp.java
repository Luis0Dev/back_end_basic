package com.bookshop.service.implement;

import com.bookshop.entity.tb_bok_book;
import com.bookshop.repository.book_repository;
import com.bookshop.service.book_service;

import org.springframework.stereotype.Service;

@Service
public class book_service_imp implements book_service {
    public book_repository book_repository;

    public void saveBook(tb_bok_book book) {
        book.set_bok_i_quantity(book.get_bok_i_quantity() + 1);
        book_repository.save(book);
    }
}
