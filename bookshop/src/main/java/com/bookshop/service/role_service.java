package com.bookshop.service;

import com.bookshop.entity.tb_rol_role;

public interface role_service {
    tb_rol_role findByName(String name);
}