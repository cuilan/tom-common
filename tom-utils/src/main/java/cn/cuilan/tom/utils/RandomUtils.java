package cn.cuilan.tom.utils;

import java.util.Random;

public class RandomUtils {
    private static final char[] numbersAndLetters = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] numbers = "123456789".toCharArray();
    private static final Random randGen = new Random();

    public RandomUtils() {
    }

    public static String randomString(int length) {
        if (length < 1) {
            return null;
        } else {
            char[] randBuffer = new char[length];

            for(int i = 0; i < randBuffer.length; ++i) {
                randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
            }

            return new String(randBuffer);
        }
    }

    public static String randomInt(int length) {
        if (length < 1) {
            return null;
        } else {
            char[] randBuffer = new char[length];

            for(int i = 0; i < randBuffer.length; ++i) {
                randBuffer[i] = numbers[randGen.nextInt(9)];
            }

            return new String(randBuffer);
        }
    }
}
