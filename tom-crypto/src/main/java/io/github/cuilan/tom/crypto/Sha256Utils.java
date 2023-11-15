package io.github.cuilan.tom.crypto;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Formatter;

public class Sha256Utils {

    public static String encrypt(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(hex2Bytes(salt));
            md.update(password.getBytes(StandardCharsets.UTF_8));
            return byte2Hex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("hash error: " + e.getMessage());
        }
    }

    public static String genSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        return byte2Hex(salt);
    }

    private static String byte2Hex(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        String hash = formatter.toString();
        formatter.close();
        return hash;
    }

    private static byte[] hex2Bytes(String hex) {
        return new BigInteger(hex, 16).toByteArray();
    }

}