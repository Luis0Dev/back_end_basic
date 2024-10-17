package com.bookshop.entity;

import jakarta.persistence.*;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class tb_usr_user_certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID usrc_n_id;

    @Column(nullable = false)
    public String usrc_c_certificate_hash;

    @ManyToMany(mappedBy = "usr_usr_c_certificate")
    public Set<tb_usr_user> usr_usr_c_certificate = new HashSet<>();
}
