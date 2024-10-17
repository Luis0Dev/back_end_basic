package com.bookshop.service.implement;

import com.bookshop.entity.tb_rol_role;
import com.bookshop.entity.tb_usr_user;
import com.bookshop.service.user_service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class spring_data_service_imp implements UserDetailsService {
    public user_service user_service;

    public void set_user_repository(user_service user_service) {
        this.user_service = user_service;
    }
    @Override
    public UserDetails loadUserByUsername(String username){
        tb_usr_user user = user_service.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (tb_rol_role role : user.get_usr_rol_c_role()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.get_rol_c_name()));
        }
        return new user_service_current_imp(user.get_usr_c_username(), user.get_usr_c_password(),
                grantedAuthorities, user);
    }

}
