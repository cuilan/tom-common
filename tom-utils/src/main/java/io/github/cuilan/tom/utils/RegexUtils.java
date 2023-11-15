package io.github.cuilan.tom.utils;

import io.github.cuilan.tom.constants.RegexConst;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 *
 * @author zhangyan
 * @since 2021/12/14
 */
public class RegexUtils {

    /**
     * 正则校验，是否为中国大陆地区手机号
     *
     * @param phone 手机号
     * @return 返回boolean类型
     */
    public static boolean isChinaPhoneNumber(String phone) {
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(RegexConst.PHONE_REGEX);
            Matcher m = p.matcher(phone);
            return m.matches();
        }
    }

    /**
     * 正则校验，是否为格式化时间字符串，长度14，精确到秒
     *
     * @param yyyyMMddHHmmss 时间字符串
     * @return 返回boolean类型
     */
    public static boolean isTimeLength14(String yyyyMMddHHmmss) {
        if (yyyyMMddHHmmss.length() != 14) {
            return false;
        } else {
            Pattern p = Pattern.compile(RegexConst.TIME_PATTERN_14);
            Matcher m = p.matcher(yyyyMMddHHmmss);
            return m.matches();
        }
    }

    /**
     * 正则校验，是否为格式化时间字符串，长度12，精确到分钟
     *
     * @param yyyyMMddHHmm 时间字符串
     * @return 返回boolean类型
     */
    public static boolean isTimeLength12(String yyyyMMddHHmm) {
        if (yyyyMMddHHmm.length() != 12) {
            return false;
        } else {
            Pattern p = Pattern.compile(RegexConst.TIME_PATTERN_12);
            Matcher m = p.matcher(yyyyMMddHHmm);
            return m.matches();
        }
    }

    /**
     * 正则校验，是否为格式化时间字符串，长度19
     *
     * @param time 时间字符串，格式：yyyy-MM-dd HH:mm:ss
     * @return 返回boolean类型
     */
    public static boolean isFormatTime(String time) {
        if (time.length() != 19) {
            return false;
        } else {
            Pattern p = Pattern.compile(RegexConst.TIME_FORMAT);
            Matcher m = p.matcher(time);
            return m.matches();
        }
    }

}
