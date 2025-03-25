package com.taskmanagement.taskmanagement.generator;

import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class HashGenerator {

    static public String generateHash(String timestamp, Long userId, int counter) {
        try {

            // SHA-256 hashleme için giriş verisi olusturma isi
            String input = timestamp + userId + counter;

            // SHA-256 hash olusturma isi
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Byte dizi -> hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }


            return hexString.substring(0, 4);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm are not found", e);
        }
    }
}
