package io.github.cuilan.tom.crypto;

import org.hashids.Hashids;

/**
 * ID混淆工具
 *
 * @author zhang.yan
 * @since 2021/11/17
 */
public class HashIdsUtils {

    private static final String SALT = "u#$CE@PjJbEjV#Cz5eh85Vw3fcgJ^Jx$";

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

    private static final int MIN_HASH_LENGTH = 8;

    public static String encode(long id) {
        return encode(id, SALT);
    }

    public static String encode(long id, String salt) {
        Hashids hashids = new Hashids(salt, MIN_HASH_LENGTH, ALPHABET);
        return hashids.encode(id);
    }

    public static long decode(String hashedId) {
        return decode(hashedId, SALT);
    }

    public static long decode(String hashedId, String salt) {
        try {
            Hashids hashids = new Hashids(salt, MIN_HASH_LENGTH, ALPHABET);
            return hashids.decode(hashedId)[0];
        } catch (Exception e) {
            throw new IllegalArgumentException("invalid id is " + hashedId);
        }
    }

}
