package com.bookshop.service.implement;

import com.bookshop.entity.tb_bok_book;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import org.springframework.stereotype.Component;

import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class order_service_imp {
    public Map<UUID, tb_bok_book> order_book_map = new HashMap<>();

    public void add_to_cart(tb_bok_book book) {
        if (order_book_map.containsKey(book.get_bok_n_id())) {
            order_book_map.get(book.get_bok_n_id()).set_bok_i_quantity(order_book_map.get(book.get_bok_n_id()).get_bok_i_quantity() + 1);
        } else {
            order_book_map.put(book.get_bok_n_id(), book);
        }
    }
    public void remove(tb_bok_book book) {
        this.order_book_map.remove(book.get_bok_n_id());
    }
    public void plus(tb_bok_book book) {
        order_book_map.get(book.get_bok_n_id()).set_bok_i_quantity(order_book_map.get(book.get_bok_n_id()).get_bok_i_quantity() + 1);
        ;
    }
    public void minus(tb_bok_book book) {
        if (order_book_map.get(book.get_bok_n_id()).get_bok_i_quantity() == 1) {
            this.order_book_map.remove(book.get_bok_n_id());
        } else {
            order_book_map.get(book.get_bok_n_id()).set_bok_i_quantity(order_book_map.get(book.get_bok_n_id()).get_bok_i_quantity() - 1);
            ;
        }
    }
}
