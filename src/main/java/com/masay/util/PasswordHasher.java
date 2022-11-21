package com.masay.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {
    private static StringBuilder sb = new StringBuilder();

    public static String hash_password(String password) throws NoSuchAlgorithmException {
        MessageDigest ms = MessageDigest.getInstance("SHA-224");
        ms.update(password.getBytes(StandardCharsets.UTF_8));
        byte[] result = ms.digest();
        for ( byte b:result )
            sb.append(String.format("%02x",b));

        String hashedPass = sb.toString();
        sb = null;
        return hashedPass;
    }
}