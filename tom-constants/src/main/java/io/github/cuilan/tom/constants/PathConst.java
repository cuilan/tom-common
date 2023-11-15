package io.github.cuilan.tom.constants;

/**
 * 路径常量
 *
 * @author zhangyan
 * @since 2021/12/7
 */
public class PathConst {

    /**
     * 跟目录
     */
    public static final String ROOT_DIR = "/";

    /**
     * /tmp 目录
     */
    public static final String TMP_DIR = ROOT_DIR + "tmp";

    /**
     * /temp 目录
     */
    public static final String TEMP_DIR = ROOT_DIR + "temp";

    /**
     * /usr 目录
     */
    public static final String USR_DIR = ROOT_DIR + "usr";

    /**
     * /home 目录
     */
    public static final String HOME_DIR = ROOT_DIR + "home";

    /**
     * 用户家目录
     */
    public static final String USER_HOME_DIR = System.getProperty("user.home");

    /**
     * 当前工作目录
     */
    public static final String CURRENT_DIR = System.getProperty("user.dir");

    /**
     * 文件分隔符
     */
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");

    /**
     * path分隔符
     */
    public static final String PATH_SEPARATOR = System.getProperty("path.separator");

    /**
     * 换行符
     */
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

}
