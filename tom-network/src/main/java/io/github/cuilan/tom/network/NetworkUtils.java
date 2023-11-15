package io.github.cuilan.tom.network;

import cn.hutool.core.util.StrUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 网络工具类
 *
 * @author zhang.yan
 */
public class NetworkUtils {

    private static final String IP_UNKNOWN = "unknown";

    private NetworkUtils() {
        // 工具类应隐藏 public 构造器。
    }

    /**
     * 获取ip地址
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {

        // 从Nginx中X-Real-IP获取真实ip
        String ip = request.getHeader("X-Real-IP");
        if (checkIp(ip)) {
            return ip;
        }

        ip = request.getHeader("x-forwarded-for");
        if (checkIp(ip)) {
            return ip;
        }

        ip = request.getHeader("WL-Proxy-Client-IP");
        if (checkIp(ip)) {
            return ip;
        }

        ip = request.getHeader("HTTP_CLIENT_IP");
        if (checkIp(ip)) {
            return ip;
        }

        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        if (checkIp(ip)) {
            return ip;
        }

        return request.getRemoteAddr();
    }

    private static boolean checkIp(String ip) {
        return StrUtil.isNotBlank(ip) && !IP_UNKNOWN.equalsIgnoreCase(ip);
    }
}
