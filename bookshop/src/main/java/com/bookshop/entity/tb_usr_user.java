package com.bookshop.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_usr_user")
public class tb_usr_user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;
    public String username;
    public String password;

    public String email;
    public String firstName;
    public String lastName;
    public LocalDateTime dateOfBirth;

    public String streetAddress;
    public int houseNumber;
    public int apartmentNumber;
    public String zipCode;
    public String city;

    public int status;

    public String encrypted_data;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "usr_c_role", joinColumns = @JoinColumn(name = "usr_n_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_n_id"))
    public Set<tb_rol_role> usr_rol_c_role;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "usr_usr_c_certificate", joinColumns = @JoinColumn(name = "usr_n_id"),
            inverseJoinColumns = @JoinColumn(name = "usr_n_id"))
    public Set<tb_rol_role> usr_usr_c_certificate;

    //GETTERS
    public UUID get_usr_n_id() {
        return id;
    }
    public String get_usr_c_username() {
        return username;
    }
    public String get_usr_c_password() {
        return password;
    }
    public String get_usr_c_email() {
        return email;
    }
    public String get_usr_c_first_name() {
        return firstName;
    }
    public String get_usr_c_last_name() {
        return lastName;
    }
    public LocalDateTime get_usr_dt_date_of_birth() {
        return dateOfBirth;
    }
    public String get_usr_c_street_address() {
        return streetAddress;
    }
    public int get_usr_i_house_number() {
        return houseNumber;
    }
    public int get_usr_i_apartment_number() {
        return apartmentNumber;
    }
    public String get_usr_c_zip_code() {
        return zipCode;
    }
    public String get_usr_c_city() {
        return city;
    }
    public int get_usr_i_status() {
        return status;
    }
    public String get_usr_encrypted_data() {
        return encrypted_data;
    }
    public Set<tb_rol_role> get_usr_rol_c_role() {
        return usr_rol_c_role;
    }
    public Set<tb_rol_role> get_usr_usr_c_certificate() {
        return usr_usr_c_certificate;
    }

    //SETTERS
    public void set_usr_n_id(UUID id) {
        this.id = id;
    }
    public void set_usr_c_username(String username) {
        this.username = username;
    }
    public void set_usr_c_password(String password) {
        this.password = password;
    }
    public void set_usr_c_email(String email) {
        this.email = email;
    }
    public void set_usr_c_first_name(String firstName) {
        this.firstName = firstName;
    }
    public void set_usr_c_last_name(String lastName) {
        this.lastName = lastName;
    }
    public void set_usr_dt_date_of_birth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void set_usr_c_street_address(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    public void set_usr_i_house_number(int houseNumber) {
        this.houseNumber = houseNumber;
    }
    public void set_usr_i_apartment_number(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
    public void set_usr_c_zip_code(String zipCode) {
        this.zipCode = zipCode;
    }
    public void set_usr_c_city(String city) {
        this.city = city;
    }
    public void set_usr_i_status(int status) {
        this.status = status;
    }
    public  void set_usr_encrypted_data(String encrypted_data) {
        this.encrypted_data = encrypted_data;
    }
    public void set_usr_rol_c_role(Set<tb_rol_role> usr_rol_c_role) {
        this.usr_rol_c_role = usr_rol_c_role;
    }
    public void set_usr_usr_c_certificate(Set<tb_rol_role> usr_usr_c_certificate) {
        this.usr_usr_c_certificate = usr_usr_c_certificate;
    }
}
