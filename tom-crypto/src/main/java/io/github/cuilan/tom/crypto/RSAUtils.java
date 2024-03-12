package io.github.cuilan.tom.crypto;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

/**
 * RSA非对称加密工具
 *
 * @author zhangyan
 * @since 2024/3/12
 */
public class RSAUtils {

    /**
     * 生成公钥私钥对
     *
     * @return key：私钥，value：公钥
     */
    public static Pair<String, String> genPubPriPair() {
        RSA rsa = new RSA();
        // 获得私钥
        String privateKey = rsa.getPrivateKeyBase64();
        // 获得公钥
        String publicKey = rsa.getPublicKeyBase64();
        return new Pair<>(privateKey, publicKey);
    }

    // ==================== 加密 ====================

    /**
     * 私钥加密
     *
     * @param privateKeyBase64 私钥BASE64
     * @param source           原文
     * @return 密文字符串
     */
    public static String encryptByPrivateKey(String privateKeyBase64, String source) {
        byte[] encrypt = encryptByPrivateKey(Base64.decode(privateKeyBase64), source);
        return Base64.encode(encrypt);
    }

    /**
     * 私钥加密
     *
     * @param privateKey 私钥
     * @param source     原文
     * @return 密文byte[]
     */
    public static byte[] encryptByPrivateKey(byte[] privateKey, String source) {
        RSA rsa = new RSA(privateKey, null);
        return rsa.encrypt(StrUtil.bytes(source, CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);
    }

    /**
     * 公钥加密
     *
     * @param publicKeyBase64 公钥BASE64
     * @param source          原文
     * @return 密文字符串
     */
    public static String encryptByPublicKey(String publicKeyBase64, String source) {
        byte[] encrypt = encryptByPublicKey(Base64.decode(publicKeyBase64), source);
        return Base64.encode(encrypt);
    }

    /**
     * 公钥加密
     *
     * @param publicKey 公钥
     * @param source    原文
     * @return 密文byte[]
     */
    public static byte[] encryptByPublicKey(byte[] publicKey, String source) {
        RSA rsa = new RSA(null, publicKey);
        return rsa.encrypt(StrUtil.bytes(source, CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
    }

    // ==================== 解密 ====================

    /**
     * 私钥解密
     *
     * @param privateKeyBase64 私钥BASE64
     * @param encrypt          密文
     * @return 原文
     */
    public static String decryptByPrivateKey(String privateKeyBase64, String encrypt) {
        byte[] decrypt = decryptByPrivateKey(Base64.decode(privateKeyBase64), encrypt);
        return StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);
    }

    /**
     * 私钥解密
     *
     * @param privateKey 私钥
     * @param encrypt    密文
     * @return 原文
     */
    public static byte[] decryptByPrivateKey(byte[] privateKey, String encrypt) {
        RSA rsa = new RSA(privateKey, null);
        return rsa.decrypt(encrypt, KeyType.PrivateKey);
    }

    /**
     * 公钥解密
     *
     * @param publicKeyBase64 公钥BASE64
     * @param encrypt         密文
     * @return 原文
     */
    public static String decryptByPublicKey(String publicKeyBase64, String encrypt) {
        byte[] decrypt = decryptByPublicKey(Base64.decode(publicKeyBase64), encrypt);
        return StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);
    }

    /**
     * 公钥解密
     *
     * @param publicKey 公钥
     * @param encrypt   密文
     * @return 原文
     */
    public static byte[] decryptByPublicKey(byte[] publicKey, String encrypt) {
        RSA rsa = new RSA(null, publicKey);
        return rsa.decrypt(encrypt, KeyType.PublicKey);
    }

    public static void main(String[] args) {
        // 生成秘钥对
        Pair<String, String> pair = RSAUtils.genPubPriPair();
        String privateKey = pair.getKey();
        String publicKey = pair.getValue();

        // 公钥加密
        String encrypt = encryptByPublicKey(publicKey, "RAS公钥加密，私钥解密");
        System.out.println(encrypt);
        // 私钥解密
        String source = decryptByPrivateKey(privateKey, encrypt);
        System.out.println(source);

        // 私钥加密
        String encrypt1 = encryptByPrivateKey(privateKey, "RAS私钥加密，公钥解密");
        System.out.println(encrypt1);
        // 公钥解密
        String source1 = decryptByPublicKey(publicKey, encrypt1);
        System.out.println(source1);
    }

}
