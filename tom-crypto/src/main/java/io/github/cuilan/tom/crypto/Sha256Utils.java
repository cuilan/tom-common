package io.github.cuilan.tom.crypto;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Formatter;

/**
 * SHA-265工具类
 *
 * @author zhangyan
 * @since 2023/11/17
 */
public class Sha256Utils {

    /**
     * 签名加密获得16进制签名
     *
     * @param password message
     * @param salt     盐值
     * @return 16进制签名
     */
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

    /**
     * 获得随机盐值
     *
     * @return 随机盐值
     */
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