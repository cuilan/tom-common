package cn.cuilan.tom.constants;

/**
 * 简易状态码，3位数
 *
 * @author zhangyan
 * @since 2022/4/6
 */
public class SimpleErrorCode {

    public static final SimpleErrorCode FAIL = new SimpleErrorCode(100, "fail", "失败");

    public static final SimpleErrorCode SUCCESS = new SimpleErrorCode(200, "success", "成功");

    public static final SimpleErrorCode AUTH_FAIL = new SimpleErrorCode(401, "auth fail", "认证失败");
    public static final SimpleErrorCode NOT_FOUND = new SimpleErrorCode(404, "not found", "资源未找到");

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

    public SimpleErrorCode(SimpleErrorCode simpleErrorCode) {
        this(simpleErrorCode.code, simpleErrorCode.msg, simpleErrorCode.showMsg);
    }

    public SimpleErrorCode(int code) {
        this(code, "", "");
    }

    public SimpleErrorCode(int code, String msg) {
        this(code, msg, "");
    }

    public SimpleErrorCode(int code, String msg, String showMsg) {
        this.code = code;
        this.msg = msg;
        this.showMsg = showMsg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getShowMsg() {
        return showMsg;
    }
}
