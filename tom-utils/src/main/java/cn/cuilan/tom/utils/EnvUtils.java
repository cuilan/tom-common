package cn.cuilan.tom.utils;

/**
 * 获取 profile 运行时环境工具类
 *
 * @author zhang.yan
 */
public class EnvUtils {

    /**
     * test 运行时环境
     */
    public static final String PROFILE_TEST = "test";

    /**
     * prod 运行时环境
     */
    public static final String PROFILE_PRODUCTION = "prod";

    private static final String PROFILE = System.getProperty("spring.profiles.active");

    private EnvUtils() {
        // 工具类应隐藏 public 构造器。
    }

    /**
     * 判断当前是否为生产环境运行
     *
     * @return spring.profiles.active=prod 时返回 true
     */
    public static boolean isProductionEnv() {
        return PROFILE_PRODUCTION.equals(PROFILE);
    }

    /**
     * 获取当前运行时环境
     *
     * @return 返回 prod、test
     */
    public static String getProfile() {
        return PROFILE;
    }
}
