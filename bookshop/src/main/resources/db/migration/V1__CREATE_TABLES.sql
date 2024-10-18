-- SQL script to create the tables and their relationships for PostgreSQL

-- Creating the tb_ath_author table
CREATE TABLE IF NOT EXISTS tb_ath_author (
                                             ath_n_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    ath_c_first_name VARCHAR(255) NOT NULL,
    ath_c_last_name VARCHAR(255) NOT NULL
    );

-- Creating the tb_bok_book table
CREATE TABLE IF NOT EXISTS tb_bok_book (
                                           bok_n_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    bok_n_title VARCHAR(255) NOT NULL,
    bok_n_description TEXT,
    bok_dt_date_publisher TIMESTAMP,
    bok_i_quantity INT,
    bok_i_price DECIMAL
    );

-- Creating the tb_ctg_category table
CREATE TABLE IF NOT EXISTS tb_ctg_category (
                                               ctg_n_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    ct_gc_name VARCHAR(255) NOT NULL
    );

-- Creating the tb_ord_order table
CREATE TABLE IF NOT EXISTS tb_ord_order (
                                            ord_n_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    ord_i_quantity INT NOT NULL,
    ord_i_amount DECIMAL NOT NULL
    );

-- Creating the tb_ord_order_book table
CREATE TABLE IF NOT EXISTS tb_ord_order_book (
                                                 ord_n_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    ord_n_title VARCHAR(255) NOT NULL,
    ord_n_description TEXT,
    ord_dt_date_publisher TIMESTAMP,
    ord_d_price DECIMAL,
    ord_i_quantity INT
    );

-- Creating the tb_pbs_publisher table
CREATE TABLE IF NOT EXISTS tb_pbs_publisher (
                                                pbs_n_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    pbs_c_name VARCHAR(255) NOT NULL,
    bok_phs_c_publisher_bok_n_id UUID,
    ord_bok_phs_c_publisher_ord_n_id UUID,
    FOREIGN KEY (bok_phs_c_publisher_bok_n_id) REFERENCES tb_bok_book (bok_n_id),
    FOREIGN KEY (ord_bok_phs_c_publisher_ord_n_id) REFERENCES tb_ord_order_book (ord_n_id)
    );

-- Creating the tb_rol_role table
CREATE TABLE IF NOT EXISTS tb_rol_role (
                                           rol_n_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    rol_c_name VARCHAR(255) NOT NULL
    );

-- Creating the tb_usr_user table
CREATE TABLE IF NOT EXISTS tb_usr_user (
                                           usr_n_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    usr_c_username VARCHAR(255) NOT NULL,
    usr_c_password VARCHAR(255) NOT NULL,
    usr_c_email VARCHAR(255) NOT NULL,
    usr_c_first_name VARCHAR(255),
    usr_c_last_name VARCHAR(255),
    usr_dt_date_of_birth TIMESTAMP,
    usr_c_street_address VARCHAR(255),
    usr_i_house_number INT,
    usr_i_apartment_number INT,
    usr_c_zip_code VARCHAR(20),
    usr_c_city VARCHAR(255),
    usr_i_status INT,
    usr_encrypted_data TEXT
    );

-- Creating the tb_usr_user_certificate table
CREATE TABLE IF NOT EXISTS tb_usr_user_certificate (
                                                       usrc_n_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    usrc_c_certificate_hash VARCHAR(255) NOT NULL
    );

-- Creating the author_book join table
CREATE TABLE IF NOT EXISTS author_book (
                                           ath_n_id UUID NOT NULL REFERENCES tb_ath_author(ath_n_id),
    bok_n_id UUID NOT NULL REFERENCES tb_bok_book(bok_n_id),
    PRIMARY KEY (ath_n_id, bok_n_id)
    );

-- Creating the category_book join table
CREATE TABLE IF NOT EXISTS category_book (
                                             ctg_n_id UUID NOT NULL REFERENCES tb_ctg_category(ctg_n_id),
    bok_n_id UUID NOT NULL REFERENCES tb_bok_book(bok_n_id),
    PRIMARY KEY (ctg_n_id, bok_n_id)
    );

-- Creating the author_order_book join table
CREATE TABLE IF NOT EXISTS author_order_book (
                                                 ath_n_id UUID NOT NULL REFERENCES tb_ath_author(ath_n_id),
    ord_n_id UUID NOT NULL REFERENCES tb_ord_order_book(ord_n_id),
    PRIMARY KEY (ath_n_id, ord_n_id)
    );

-- Creating the category_order_book join table
CREATE TABLE IF NOT EXISTS category_order_book (
                                                   ctg_n_id UUID NOT NULL REFERENCES tb_ctg_category(ctg_n_id),
    ord_n_id UUID NOT NULL REFERENCES tb_ord_order_book(ord_n_id),
    PRIMARY KEY (ctg_n_id, ord_n_id)
    );

-- Creating the user-role join table
CREATE TABLE IF NOT EXISTS usr_c_role (
                                          usr_n_id UUID NOT NULL REFERENCES tb_usr_user(usr_n_id),
    rol_n_id UUID NOT NULL REFERENCES tb_rol_role(rol_n_id),
    PRIMARY KEY (usr_n_id, rol_n_id)
    );

-- Creating the user-certificate join table
CREATE TABLE IF NOT EXISTS usr_usr_c_certificate (
                                                     usr_n_id UUID NOT NULL REFERENCES tb_usr_user(usr_n_id),
    usrc_n_id UUID NOT NULL REFERENCES tb_usr_user_certificate(usrc_n_id),
    PRIMARY KEY (usr_n_id, usrc_n_id)
    );
