package com.bookshop.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_odr_order_book")
public class tb_ord_order_book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID ord_n_id;
    public String ord_n_title;
    public String ord_n_description;
    public LocalDateTime ord_dt_date_publisher;

    public double ord_d_price;
    public int ord_i_quantity;

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "author_order_book",
            joinColumns = {@JoinColumn(name = "ord_n_id")},
            inverseJoinColumns = {@JoinColumn(name = "ath_n_id")}
    )
    public Set<tb_ath_author> ord_bok_ath_c_author = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "category_order_book",
            joinColumns = {@JoinColumn(name = "ord_n_id")},
            inverseJoinColumns = {@JoinColumn(name = "ctg_n_id")}
    )
    public Set<tb_ctg_category> ord_bok_ctg_c_category = new HashSet<>();

    @OneToMany
    private Set<tb_pbs_publisher> ord_bok_pbs_c_publisher = new HashSet<>();

    public tb_ord_order_book() {}

    //GETTERS
    public UUID get_ord_n_id() {
        return ord_n_id;
    }
    public String get_ord_n_title() {
        return ord_n_title;
    }
    public String get_ord_n_description() {
        return ord_n_description;
    }
    public LocalDateTime get_ord_dt_date_publisher() {
        return ord_dt_date_publisher;
    }
    public double get_ord_d_price() {
        return ord_d_price;
    }
    public int get_ord_i_quantity() {
        return ord_i_quantity;
    }
    public Set<tb_ath_author> get_ord_bok_ath_c_author() {
        return ord_bok_ath_c_author;
    }
    public Set<tb_ctg_category> get_ord_bok_ctg_c_category() {
        return ord_bok_ctg_c_category;
    }
    public Set<tb_pbs_publisher> get_ord_bok_pbs_c_publisher() {
        return ord_bok_pbs_c_publisher;
    }

    //SETTERS
    public void set_ord_n_id(UUID ord_n_id) {
        this.ord_n_id = ord_n_id;
    }
    public void set_ord_n_title(String ord_n_title) {
        this.ord_n_title = ord_n_title;
    }
    public void set_ord_n_description(String ord_n_description) {
        this.ord_n_description = ord_n_description;
    }
    public void set_ord_dt_date_publisher(LocalDateTime ord_dt_date_publisher) {
        this.ord_dt_date_publisher = ord_dt_date_publisher;
    }
    public void set_ord_d_price(double ord_d_price) {
        this.ord_d_price = ord_d_price;
    }
    public void set_ord_i_quantity(int ord_i_quantity) {
        this.ord_i_quantity = ord_i_quantity;
    }
    public void set_ord_bok_ath_c_author(Set<tb_ath_author> ord_bok_ath_c_author){
        this.ord_bok_ath_c_author = ord_bok_ath_c_author;
    }
    public void set_ord_bok_ctg_category(Set<tb_ctg_category> ord_bok_ctg_category){
        this.ord_bok_ctg_c_category = ord_bok_ctg_category;
    }
    public void set_ord_bok_pbs_c_publisher(Set<tb_pbs_publisher> ord_bok_pbs_c_publisher) {
        this.ord_bok_pbs_c_publisher = ord_bok_pbs_c_publisher;
    }
}
