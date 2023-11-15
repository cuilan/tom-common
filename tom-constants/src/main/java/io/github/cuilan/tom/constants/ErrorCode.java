package io.github.cuilan.tom.constants;

import lombok.Getter;

/**
 * 全局统一错误码，5位数
 *
 * @author zhang.yan
 * @since 2021/10/12
 */
@Getter
public class ErrorCode {

    /**
     * 10000，成功
     */
    public static final ErrorCode SUCCESS = new ErrorCode(10000, "成功");

    /**
     * 10001，失败
     */
    public static final ErrorCode FAIL = new ErrorCode(10001, "失败");

    /**
     * 10002，系统内部错误
     */
    public static final ErrorCode SYSTEM_ERROR = new ErrorCode(10002, "系统内部错误");

    /**
     * gRPC 20000，服务不可用
     */
    public static final ErrorCode SERVICE_UNAVAILABLE = new ErrorCode(20000, "服务不可用");

    /**
     * gRPC 20001，认证失败，服务
     */
    public static final ErrorCode SERVICE_AUTHENTICATE_FAIL = new ErrorCode(20001, "认证失败，服务");

    /**
     * gRPC 20002，缓存服务不可用
     */
    public static final ErrorCode CACHE_SERVICE_UNAVAILABLE = new ErrorCode(20002, "缓存服务不可用");

    /**
     * 业务状态码 30000，参数不正确
     */
    public static final ErrorCode PARAM_TYPE_MISMATCH = new ErrorCode(30000, "参数不正确");

    /**
     * 业务状态码 30001，不支持的请求方式
     */
    public static final ErrorCode REQUEST_METHOD_NOT_SUPPORT = new ErrorCode(30001, "不支持的请求方式");

    /**
     * 业务状态码 30002，用户不存在
     */
    public static final ErrorCode USER_NOT_EXIST = new ErrorCode(30002, "用户不存在");

    /**
     * 业务状态码 30003，用户被禁止
     */
    public static final ErrorCode USER_IS_BANNED = new ErrorCode(30003, "用户被禁止");

    /**
     * 业务状态码 30004，密码不正确
     */
    public static final ErrorCode INCORRECT_PASSWORD = new ErrorCode(30004, "密码不正确");

    /**
     * 业务状态码 30005，密码长度不正确
     */
    public static final ErrorCode INCORRECT_PASSWORD_LENGTH = new ErrorCode(30005, "密码长度不正确");

    /**
     * 业务状态码 30006，校验码错误
     */
    public static final ErrorCode VERIFY_KEY_ERROR = new ErrorCode(30006, "校验码错误");

    /**
     * 业务状态码 30007，短信验证码错误
     */
    public static final ErrorCode SMS_CODE_ERROR = new ErrorCode(30007, "短信验证码错误");

    /**
     * 数据异常 40000，数据错误
     */
    public static final ErrorCode DATA_ERROR = new ErrorCode(40000, "数据错误");

    /**
     * 数据异常 40001，数据重复
     */
    public static final ErrorCode DATA_DUPLICATION = new ErrorCode(40001, "数据重复");

    /**
     * 数据异常 40002，数据格式错误
     */
    public static final ErrorCode DATA_FORMAT_ERROR = new ErrorCode(40002, "数据格式错误");

    /**
     * 数据异常 40003，数据不存在
     */
    public static final ErrorCode DATA_NOT_EXIST_ERROR = new ErrorCode(40003, "数据不存在");

    /**
     * 文件操作 50001，文件为空
     */
    public static final ErrorCode FILE_IS_EMPTY = new ErrorCode(50001, "文件为空");

    /**
     * 文件操作 50002，文件太大
     */
    public static final ErrorCode FILE_SIZE_TOO_LARGE = new ErrorCode(50002, "文件太大");

    /**
     * 文件操作 50003，文件类型不支持
     */
    public static final ErrorCode FILE_TYPE_UNSUPPORTED = new ErrorCode(50003, "文件类型不支持");

    /**
     * 文件操作 50004，文件不存在
     */
    public static final ErrorCode FILE_NOT_EXISTS = new ErrorCode(50004, "文件不存在");

    /**
     * 文件操作 50005，文件权限认证失败
     */
    public static final ErrorCode FILE_PERMISSION_FAILED = new ErrorCode(50005, "文件权限认证失败");

    /**
     * 权限认证
     */
    public static final ErrorCode AUTHENTICATE_FAIL = new ErrorCode(60000, "认证失败");

    /**
     * 权限认证 60001，签名失败
     */
    public static final ErrorCode SIGN_FAIL = new ErrorCode(60001, "签名失败");

    /**
     * 权限认证 60002，权限验证失败
     */
    public static final ErrorCode PERMISSION_FAILED = new ErrorCode(60002, "权限验证失败");

    /**
     * 权限认证 60003，角色验证失败
     */
    public static final ErrorCode ROLE_FAILED = new ErrorCode(60003, "角色验证失败");

    /**
     * 权限认证 60004，加密失败
     */
    public static final ErrorCode ENCODE_FAILED = new ErrorCode(60004, "加密失败");

    /**
     * 权限认证 60005，解密失败
     */
    public static final ErrorCode DECODE_FAILED = new ErrorCode(60005, "解密失败");

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
     * 服务名称
     */
    private final String service;

    /**
     * 服务节点名称
     */
    private final String node;

    /**
     * 默认服务名称
     */
    private static final String DEFAULT_SERVICE = "";

    /**
     * 默认节点名称
     */
    private static final String DEFAULT_NODE = "";

    /**
     * 错误码、服务名称构造器
     *
     * @param errorCode 错误码
     * @param service   服务名称
     */
    public ErrorCode(ErrorCode errorCode, String service) {
        this.code = errorCode.code;
        this.msg = errorCode.msg;
        this.service = service;
        this.node = DEFAULT_NODE;
    }

    /**
     * 错误码、服务名称、节点构造器
     *
     * @param errorCode 错误码
     * @param service   服务名称
     * @param node      节点
     */
    public ErrorCode(ErrorCode errorCode, String service, String node) {
        this.code = errorCode.code;
        this.msg = errorCode.msg;
        this.service = service;
        this.node = node;
    }

    /**
     * 自定义错误码、自定义消息构造器
     *
     * @param code 自定义错误码
     * @param msg  自定义消息
     */
    public ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.service = DEFAULT_SERVICE;
        this.node = DEFAULT_NODE;
    }

    /**
     * 自定义错误码、自定义消息、服务名称构造器
     *
     * @param code    自定义错误码
     * @param msg     自定义消息
     * @param service 服务名称
     */
    public ErrorCode(int code, String msg, String service) {
        this.code = code;
        this.msg = msg;
        this.service = service;
        this.node = DEFAULT_NODE;
    }

    /**
     * 自定义错误码、自定义消息、服务名称、节点名称构造器
     *
     * @param code    自定义错误码
     * @param msg     自定义消息
     * @param service 服务名称
     * @param node    节点名称
     */
    public ErrorCode(int code, String msg, String service, String node) {
        this.code = code;
        this.msg = msg;
        this.service = service;
        this.node = node;
    }

    /**
     * 格式化输出消息
     *
     * @return 格式化消息
     */
    protected String getMsg() {
        String prefix = "";
        if (service != null && !service.isEmpty()) {
            prefix = service + "-";
        }
        if (node != null && !node.isEmpty()) {
            prefix = node + "-";
        }
        return prefix + msg;
    }
}
