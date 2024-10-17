package com.bookshop.service.implement;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

import java.util.Base64;

public class aes_encryption_service_imp {
    private static final String AES = "AES";
    private static final String AES_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String HMAC_ALGORITHM = "HmacSHa256";
    private final SecretKey key;
    private final byte[] hmac_key;

    public aes_encryption_service_imp() throws NoSuchAlgorithmException {
        KeyGenerator key_generator = KeyGenerator.getInstance(AES);
        key_generator.init(256);
        this.key = key_generator.generateKey();

        KeyGenerator hmac_key_generator = KeyGenerator.getInstance(HMAC_ALGORITHM);
        hmac_key_generator.init(256);
        this.hmac_key = hmac_key_generator.generateKey().getEncoded();
    }

    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted_data = cipher.doFinal(data.getBytes());
        String encrypted_string = Base64.getEncoder().encodeToString(encrypted_data);

        String hmac = calculate_hmac(encrypted_string);
        return encrypted_string + ":" + hmac;
    }

    public String decrypt(String encrypted_data_with_hmac) throws Exception {
        String[] parts = encrypted_data_with_hmac.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid format of encrypted data");
        }
        String encrypted_data = parts[0];
        String received_hmac = parts[1];

        String calculated_hmac = calculate_hmac(encrypted_data);
        if (!calculated_hmac.equals(received_hmac)) {
            throw new SecurityException("HMAC does not match - data may have been changed");
        }

        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted_data = cipher.doFinal(Base64.getDecoder().decode(encrypted_data));
        return new String(decrypted_data);
    }

    public String calculate_hmac(String data) throws Exception {
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        SecretKeySpec secret_key_spec = new SecretKeySpec(hmac_key, HMAC_ALGORITHM);
        mac.init(secret_key_spec);
        byte[] hmac_bytes = mac.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(hmac_bytes);
    }
}
