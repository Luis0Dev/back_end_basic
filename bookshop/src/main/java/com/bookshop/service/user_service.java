package com.bookshop.service;

import com.bookshop.entity.tb_usr_user;

public interface user_service {

    tb_usr_user findByUsername(String username);
    void saveUser(tb_usr_user user, String name);
}
