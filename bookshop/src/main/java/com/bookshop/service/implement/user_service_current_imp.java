package com.bookshop.service.implement;

import com.bookshop.entity.tb_usr_user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class user_service_current_imp extends User {
    public tb_usr_user user;

    public user_service_current_imp (String username, String password, Collection<?
                extends GrantedAuthority> authorities,
    tb_usr_user user) {
        super(username, password, authorities);
        this.user = user;
    }
    public tb_usr_user getUser() {
        return user;
    }
}
