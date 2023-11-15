package io.github.cuilan.tom.crypto;

import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;

/**
 * AES加密解密工具
 *
 * @author zhang.yan
 */
public class AESUtils {

    private AESUtils() {
        // 工具类应隐藏 public 构造器。
    }

    /**
     * 生成key
     *
     * @return key
     */
    public static String generateKey() {
        // AES/CBC/PKCS5Padding
        byte[] keyBytes = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        return HexUtil.encodeHexStr(keyBytes);
    }

    /**
     * AES加密
     *
     * @param secretKey 秘钥
     * @param data      原始数据
     * @return 返回16进制形式的密文
     */
    public static String encrypt(String secretKey, String data) {
        return HexUtil.encodeHexStr(SecureUtil.aes(secretKey.getBytes()).encrypt(data));
    }

    /**
     * AES解密
     *
     * @param secretKey   秘钥
     * @param encryptData 16进制形式的密文
     * @return 返回原始数据
     */
    public static String decrypt(String secretKey, String encryptData) {
        return new String(SecureUtil.aes(secretKey.getBytes()).decrypt(HexUtil.decodeHex(encryptData)));
    }

}
