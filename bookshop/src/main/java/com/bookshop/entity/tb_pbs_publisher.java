package com.bookshop.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_pbs_publisher")
public class tb_pbs_publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID pbs_n_id;
    public String pbs_c_name;

    @ManyToOne
    public tb_bok_book bok_phs_c_publisher;

    @ManyToOne
    public tb_ord_order_book ord_bok_phs_c_publisher;

    public tb_pbs_publisher() {}

    //GETTERS
    public UUID get_pbs_n_id() {
        return pbs_n_id;
    }
    public String get_pbs_c_name() {
        return pbs_c_name;
    }
    public tb_bok_book get_bok_phs_c_publisher() {
        return bok_phs_c_publisher;
    }
    public tb_ord_order_book get_ord_bok_phs_c_publisher() {
        return ord_bok_phs_c_publisher;
    }

    //SETTERS
    public void set_pbs_n_id(UUID pbs_n_id) {
        this.pbs_n_id = pbs_n_id;
    }
    public void set_pbs_c_name(String pbs_c_name) {
        this.pbs_c_name = pbs_c_name;
    }
    public void set_bok_phs_c_publisher(tb_bok_book bok_phs_c_publisher) {
        this.bok_phs_c_publisher = bok_phs_c_publisher;
    }
    public void set_ord_bok_phs_c_publisher(tb_ord_order_book ord_bok_phs_c_publisher) {
        this.ord_bok_phs_c_publisher = ord_bok_phs_c_publisher;
    }
}
