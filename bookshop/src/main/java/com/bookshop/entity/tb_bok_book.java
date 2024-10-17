package com.bookshop.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_bok_book")
public class tb_bok_book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID bok_n_id;
    public String bok_n_title;
    public String bok_n_description;
    public LocalDateTime bok_dt_date_publisher;

    public int bok_i_quantity;
    public int bok_i_price;

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "author_book",
            joinColumns = {@JoinColumn(name = "bok_n__id")},
            inverseJoinColumns = {@JoinColumn(name = "ath_n_id")}
    )
    public Set<tb_ath_author> bok_ath_c_author = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "category_book",
            joinColumns = {@JoinColumn(name = "bok_n_id")},
            inverseJoinColumns = {@JoinColumn(name = "ctg_n_id")}
    )
    public Set<tb_ctg_category> bok_ctg_c_category = new HashSet<>();


    public tb_bok_book() {}

    //GETTERS
    public UUID get_bok_n_id() {
        return bok_n_id;
    }
    public String get_bok_n_title() {
        return bok_n_title;
    }
    public String get_bok_n_description() {
        return bok_n_description;
    }
    public LocalDateTime get_bok_dt_date_publisher() {
        return bok_dt_date_publisher;
    }
    public int get_bok_i_quantity() {
        return bok_i_quantity;
    }
    public int get_bok_i_price() {
        return bok_i_price;
    }
    public Set<tb_ath_author> get_bok_ath_c_author() {
        return bok_ath_c_author;
    }
    public Set<tb_ctg_category> get_bok_ctg_c_category() {
        return bok_ctg_c_category;
    }

    //SETTERS
    public void set_bok_n_id(UUID bok_n_id) {
        this.bok_n_id = bok_n_id;
    }
    public void set_bok_n_title(String bok_n_title) {
        this.bok_n_title = bok_n_title;
    }
    public void set_bok_n_description(String bok_n_description) {
        this.bok_n_description = bok_n_description;
    }
    public void set_bok_dt_date_publisher(LocalDateTime bok_dt_date_publisher) {
        this.bok_dt_date_publisher = bok_dt_date_publisher;
    }
    public void set_bok_i_quantity(int bok_i_quantity) {
        this.bok_i_quantity = bok_i_quantity;
    }
    public void set_bok_i_price(int bok_i_price) {
        this.bok_i_price = bok_i_price;
    }
    public void set_ath_c_author(Set<tb_ath_author> bok_ath_c_author){
        this.bok_ath_c_author = bok_ath_c_author;
    }
    public void set_bok_ctg_c_category(Set<tb_ctg_category> bok_ctg_c_category){
        this.bok_ctg_c_category = bok_ctg_c_category;
    }
}
