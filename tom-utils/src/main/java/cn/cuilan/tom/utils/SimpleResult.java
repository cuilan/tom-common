package cn.cuilan.tom.utils;

import cn.cuilan.tom.constants.SimpleErrorCode;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyan
 * @since 2022/4/6
 */
@Data
public class SimpleResult<T> {

    /**
     * 错误码
     */
    protected Integer code;

    /**
     * 错误信息
     */
    protected String msg;

    /**
     * 封装返回数据
     */
    protected T data;

    /**
     * 错误信息
     */
    private String showMsg;

    public SimpleResult() {
    }

    public SimpleResult(SimpleErrorCode code) {
        if (code == null) {
            throw new NullPointerException("状态码为空");
        }
        this.code = code.getCode();
    }

    public SimpleResult(SimpleErrorCode code, String showMsg) {
        this(code);
        this.showMsg = showMsg;
    }

    public SimpleResult(SimpleErrorCode code, T data) {
        this(code);
        this.data = data;
    }

    public SimpleResult(SimpleErrorCode code, String showMsg, T data) {
        this(code, data);
        this.showMsg = showMsg;
    }


    // ========== MapResult ==========

    public static MapResult map() {
        MapResult result = new MapResult();
        Map<String, Object> map = new HashMap<>();
        result.setData(map);
        result.setCode(SimpleErrorCode.SUCCESS.code);
        return result;
    }

    public static MapResult map(String msg) {
        return map(SimpleErrorCode.SUCCESS.code, msg);
    }


    public static MapResult map(Integer code, String msg) {
        MapResult result = new MapResult();
        Map<String, Object> map = new HashMap<>();
        result.setMsg(msg);
        result.setShowMsg(msg);
        result.setData(map);
        result.setCode(code);
        return result;
    }

    public static class MapResult extends SimpleResult<Map<String, Object>> {
        public MapResult data(String key, Object value) {
            this.getData().put(key, value);
            return this;
        }
    }

    // ========== static ==========

    /**
     * 普通成功仅返回状态
     */
    public static SimpleResult<?> success() {
        return new SimpleResult<>(SimpleErrorCode.SUCCESS, null);
    }

    /**
     * 返回成功状态及描述信息
     */
    public static SimpleResult<?> success(String msg) {
        return new SimpleResult<>(SimpleErrorCode.SUCCESS, msg, null);
    }

    /**
     * 仅返回成功数据
     */
    public static SimpleResult<?> success(Object data) {
        return new SimpleResult<>(SimpleErrorCode.SUCCESS, data);
    }

    /**
     * 成功
     */
    public static SimpleResult<?> success(String msg, Object data) {
        return new SimpleResult<>(SimpleErrorCode.SUCCESS, msg, data);
    }

    public static SimpleResult<?> fail(Integer code, String msg) {
        SimpleResult<Object> simpleResult = new SimpleResult<>();
        simpleResult.setCode(code);
        simpleResult.setMsg(msg);
        simpleResult.setShowMsg(msg);
        return simpleResult;
    }

    public static SimpleResult<?> fail(String msg) {
        return new SimpleResult<>(SimpleErrorCode.FAIL, msg, null);
    }

    public static SimpleResult<?> fail(String msg, Object data) {
        return new SimpleResult<>(SimpleErrorCode.FAIL, msg, data);
    }

    public static SimpleResult<?> fail(Integer code, String msg, Object data) {
        return new SimpleResult<>(new SimpleErrorCode(code, msg), data);
    }

    public static SimpleResult<?> noAuth() {
        return new SimpleResult<>(SimpleErrorCode.AUTH_FAIL, "请登录~", null);
    }

    public static SimpleResult<?> noAuth(String msg) {
        return new SimpleResult<>(SimpleErrorCode.AUTH_FAIL, msg, null);
    }

    public static SimpleResult<?> noPermission() {
        return new SimpleResult<>(SimpleErrorCode.FAIL, "没有权限~", null);
    }
}
