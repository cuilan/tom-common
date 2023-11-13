package cn.cuilan.tom.constants;

/**
 * 简易状态码，3位数
 *
 * @author zhangyan
 * @since 2022/4/6
 */
public class SimpleErrorCode {

    /**
     * 100 失败
     */
    public static final SimpleErrorCode FAIL = new SimpleErrorCode(100, "fail", "失败");

    /**
     * 200 成功
     */
    public static final SimpleErrorCode SUCCESS = new SimpleErrorCode(200, "success", "成功");

    /**
     * 401 认证失败
     */
    public static final SimpleErrorCode AUTH_FAIL = new SimpleErrorCode(401, "auth fail", "认证失败");

    /**
     * 404 资源未找到
     */
    public static final SimpleErrorCode NOT_FOUND = new SimpleErrorCode(404, "not found", "资源未找到");

    /**
     * 500 内部服务错误
     */
    public static final SimpleErrorCode SERVER_ERROR = new SimpleErrorCode(500, "server error", "内部服务错误");

    // ====================================================================================================

    /**
     * 错误码
     */
    public final int code;

    /**
     * 错误信息
     */
    public final String msg;

    /**
     * 用于给前端展示的提示信息
     */
    public final String showMsg;

    /**
     * 简易状态码构造器
     *
     * @param simpleErrorCode 简易状态码
     */
    public SimpleErrorCode(SimpleErrorCode simpleErrorCode) {
        this(simpleErrorCode.code, simpleErrorCode.msg, simpleErrorCode.showMsg);
    }

    /**
     * 自定义状态码构造器
     *
     * @param code 自定义状态码
     */
    public SimpleErrorCode(int code) {
        this(code, "", "");
    }

    /**
     * 自定义状态码、自定义消息构造器
     *
     * @param code 自定义状态码
     * @param msg  自定义消息
     */
    public SimpleErrorCode(int code, String msg) {
        this(code, msg, "");
    }

    /**
     * 自定义状态码、自定义消息、自定义前端展示消息构造器
     *
     * @param code    自定义状态码
     * @param msg     自定义消息
     * @param showMsg 用于给前端展示的提示信息
     */
    public SimpleErrorCode(int code, String msg, String showMsg) {
        this.code = code;
        this.msg = msg;
        this.showMsg = showMsg;
    }

    /**
     * 错误码
     *
     * @return 错误码
     */
    public int getCode() {
        return code;
    }

    /**
     * 消息
     *
     * @return 消息
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 用于给前端展示的提示信息
     *
     * @return 用于给前端展示的提示信息
     */
    public String getShowMsg() {
        return showMsg;
    }
}
