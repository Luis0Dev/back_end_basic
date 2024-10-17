package com.bookshop.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_ctg_category")
public class tb_ctg_category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID ctg_n_id;
    public String ct_gc_name;

    @ManyToMany(mappedBy = "bok_ctg_c_category")
    public Set<tb_bok_book> bok_ctg_c_category = new HashSet<>();

    @ManyToMany(mappedBy = "ord_bok_ctg_c_category")
    public Set<tb_ord_order_book> ord_bok_ctg_c_category = new HashSet<>();

    public tb_ctg_category() {}

    //GETTERS
    public UUID get_ctg_n_id() {
        return ctg_n_id;
    }
    public String get_ct_gc_name() {
        return ct_gc_name;
    }
    public Set<tb_bok_book> get_bok_ctg_c_category() {
        return bok_ctg_c_category;
    }
    public Set<tb_ord_order_book> get_ord_bok_ctg_c_category() {
        return ord_bok_ctg_c_category;
    }

    //SETTERS
    public void set_ctg_n_id(UUID ctg_n_id) {
        this.ctg_n_id = ctg_n_id;
    }
    public void set_ct_gc_name(String ct_gc_name) {
        this.ct_gc_name = ct_gc_name;
    }
    public void set_bok_ctg_category(Set<tb_bok_book> bok_ctg_category) {
        this.bok_ctg_c_category = bok_ctg_category;
    }
    public void set_ord_bok_c_ctg_category(Set<tb_ord_order_book> ord_bok_ctg_category) {
        this.ord_bok_ctg_c_category = ord_bok_ctg_category;
    }
}
