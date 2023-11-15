package io.github.cuilan.tom.utils;

import java.util.Random;

/**
 * 随机数生成工具
 *
 * @author zhangyan
 * @since 2023/11/13
 */
public class RandomUtils {

    private static final char[] numbersAndLetters = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private static final char[] numbers = "123456789".toCharArray();

    private static final Random randGen = new Random();

    private RandomUtils() {
    }

    /**
     * 生成固定长度的字符串（包含数字、英文大小写）
     *
     * @param length 固定长度
     * @return 随机字符串
     */
    public static String randomString(int length) {
        if (length < 1) {
            return null;
        } else {
            char[] randBuffer = new char[length];

            for (int i = 0; i < randBuffer.length; ++i) {
                randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
            }
            return new String(randBuffer);
        }
    }

    /**
     * 生成固定长度的字符串（仅包含数字）
     *
     * @param length 固定长度
     * @return 随机数字字符串
     */
    public static String randomInt(int length) {
        if (length < 1) {
            return null;
        } else {
            char[] randBuffer = new char[length];
            for (int i = 0; i < randBuffer.length; ++i) {
                randBuffer[i] = numbers[randGen.nextInt(9)];
            }
            return new String(randBuffer);
        }
    }
}
