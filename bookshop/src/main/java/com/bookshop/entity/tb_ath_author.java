package com.bookshop.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_ath_author")
public class tb_ath_author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID ath_n_id;
    public String ath_c_first_name;
    public String ath_c_last_name;
    public String ath_c_full_name;

    @ManyToMany(mappedBy = "bok_ath_c_author")
    public Set<tb_bok_book> bok_ath_bok_c_book = new HashSet<>();

    @ManyToMany(mappedBy = "ord_bok_ath_c_author")
    public Set<tb_ord_order_book> ord_bok_ath_c_author = new HashSet<>();

    public tb_ath_author() {}

    //GETTERS
    public UUID get_ath_n_id() {
        return ath_n_id;
    }

    public String get_ath_c_first_name() {
        return ath_c_first_name;
    }

    public String get_ath_c_last_name() {
        return ath_c_last_name;
    }

    public String get_ath_c_full_name() {
        return ath_c_first_name + " " + ath_c_last_name;
    }

    public Set<tb_bok_book> get_bok_ath_c_book() {
        return bok_ath_bok_c_book;
    }

    public Set<tb_ord_order_book> get_ord_bok_ath_c_author() {
        return ord_bok_ath_c_author;
    }

    //SETTERS
    public void set_ath_n_id(UUID ath_n_id) {
        this.ath_n_id = ath_n_id;
    }

    public void set_ath_c_first_name(String ath_c_first_name) {
        this.ath_c_first_name = ath_c_first_name;
    }

    public void set_ath_c_last_name(String ath_c_last_name) {
        this.ath_c_last_name = ath_c_last_name;
    }

    public void set_ath_c_full_name(String ath_c_full_name) {
        this.ath_c_full_name = ath_c_full_name;
    }

    public void set_ath_bok_c_book(Set<tb_bok_book> bok_ath_bok_c_book) {
        this.bok_ath_bok_c_book = bok_ath_bok_c_book;
    }
    public void set_ord_bok_ath_c_author(Set<tb_ord_order_book> ord_bok_ath_c_author) {
        this.ord_bok_ath_c_author = ord_bok_ath_c_author;
    }
}
