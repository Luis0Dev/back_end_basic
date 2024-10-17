package com.bookshop.service.implement;

import com.bookshop.entity.tb_rol_role;
import com.bookshop.entity.tb_usr_user;
import com.bookshop.repository.role_repository;
import com.bookshop.repository.user_repository;
import com.bookshop.service.user_service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

import java.util.*;

@Service
public class user_service_imp implements user_service {

    public aes_encryption_service_imp aes_encryption_service;
    public user_repository user_repository;
    public role_repository role_repository;
    public BCryptPasswordEncoder password_encoder;

    public user_service_imp() throws NoSuchAlgorithmException {
        this.aes_encryption_service= new aes_encryption_service_imp();
    }

    @Override
    public tb_usr_user findByUsername(String username){
        return user_repository.findByUsername(username);
    }
    @Override
    public void saveUser(tb_usr_user user, String name){
        try {
            user.password = password_encoder.encode(user.password);
            user.set_usr_i_status(1);
            tb_rol_role user_role = role_repository.findByName(name);
            user.set_usr_rol_c_role(new HashSet<>(Arrays.asList(user_role)));
            String encrypted_data = aes_encryption_service.encrypt(user.toString());
            user.set_usr_encrypted_data(encrypted_data);
            user_repository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error saving user", e);
        }
    }
    public void updateUser(tb_usr_user user){
        try {
            tb_usr_user existingUser = user_repository.findById(user.get_usr_n_id()).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
            existingUser.set_usr_c_username(user.get_usr_c_username());
            existingUser.password = password_encoder.encode(user.password);
            existingUser.set_usr_i_status(user.get_usr_i_status());
            existingUser.set_usr_rol_c_role(user.get_usr_rol_c_role());
            String encrypted_data = aes_encryption_service.encrypt(existingUser.toString());
            existingUser. set_usr_encrypted_data(encrypted_data);
            user_repository.save(existingUser);
        } catch (Exception e) {
            throw new RuntimeException("Error update user", e);
        }
    }
    public void deleteUser(UUID id) {
        user_repository.deleteById(id);
    }
    public List<tb_usr_user> getAllUsers() {
        return user_repository.findAll();
    }
    public tb_usr_user getUserById(UUID id) {
        return user_repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found user"));
    }
}
