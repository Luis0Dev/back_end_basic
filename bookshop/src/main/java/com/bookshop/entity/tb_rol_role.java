package com.bookshop.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_rol_role")
public class tb_rol_role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_n_id")
    public UUID id;
    @Column(name = "rol_c_name")
    public String name;

    public tb_rol_role() {}

    //GETTERS
    public UUID get_rol_n_id() {
        return id;
    }
    public String get_rol_c_name() {
        return name;
    }

    //SETTERS
    public void set_rol_n_id(UUID id) {
        this.id = id;
    }
    public void set_rol_c_name(String name) {
        this.name = name;
    }
}
