package com.bookshop.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_odr_order")
public class tb_ord_order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID ord_n_id;
    public int ord_i_quantity;
    public int ord_i_amount;

    public tb_ord_order() {}

    //GETTERS
    public UUID get_ord_n_id() {
        return ord_n_id;
    }
    public int get_ord_i_quantity() {
        return ord_i_quantity;
    }
    public int get_ord_i_amount() {
        return ord_i_amount;
    }

    //SETTERS
    public void set_ord_n_id(UUID ord_n_id) {
        this.ord_n_id = ord_n_id;
    }
    public void set_ord_i_quantity(int ord_i_quantity) {
        this.ord_i_quantity = ord_i_quantity;
    }
    public void set_ord_i_amount(int ord_i_amount) {
        this.ord_i_amount = ord_i_amount;
    }
}
