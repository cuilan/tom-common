package cn.cuilan.tom.utils;

import cn.cuilan.tom.constants.ErrorCode;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局返回结果
 *
 * @param <T> Object
 */
@Data
public class Result<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 封装返回数据
     */
    private T data;

    // ========== Result ==========

    public Result() {
    }

    public Result(ErrorCode code) {
        if (code == null) {
            throw new NullPointerException("状态码为空");
        }
        this.code = code.getCode();
    }

    public Result(ErrorCode code, T data) {
        this(code);
        this.data = data;
    }

    public Result(ErrorCode code, String msg, T data) {
        this(code, data);
        this.msg = msg;
    }

    public Result(ErrorCode code, String msg) {
        this.code = code.code;
        this.msg = msg;
    }

    // ========== MapResult ==========

    public static MapResult map() {
        MapResult result = new MapResult();
        Map<String, Object> map = new HashMap<>();
        result.setData(map);
        result.setCode(ErrorCode.SUCCESS.code);
        return result;
    }

    public static MapResult map(String msg) {
        return map(ErrorCode.SUCCESS.code, msg);
    }

    public static MapResult map(Integer code, String msg) {
        MapResult result = new MapResult();
        Map<String, Object> map = new HashMap<>();
        result.setMsg(msg);
        result.setData(map);
        result.setCode(code);
        return result;
    }

    public static MapResult map(Map<String, Object> dateMap) {
        MapResult result = new MapResult();
        result.setData(dateMap);
        result.setCode(ErrorCode.SUCCESS.code);
        return result;
    }

    // ========== static ==========

    /**
     * 普通成功仅返回状态
     */
    public static Result<?> success() {
        return new Result<>(ErrorCode.SUCCESS, null);
    }

    /**
     * 返回成功状态及描述信息
     */
    public static Result<?> success(String msg) {
        return new Result<>(ErrorCode.SUCCESS, msg, null);
    }

    /**
     * 仅返回成功数据
     */
    public static Result<?> success(Object data) {
        return new Result<>(ErrorCode.SUCCESS, data);
    }

    /**
     * 成功
     */
    public static Result<?> success(String msg, Object data) {
        return new Result<>(ErrorCode.SUCCESS, msg, data);
    }

    public static Result<?> fail(Integer code, String msg) {
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result<?> fail(String msg) {
        return new Result<>(ErrorCode.FAIL, msg, null);
    }

    public static Result<?> fail(String msg, Object data) {
        return new Result<>(ErrorCode.FAIL, msg, data);
    }

    public static Result<?> fail(Integer code, String msg, Object data) {
        return new Result<>(new ErrorCode(code, msg), data);
    }

    public static Result<?> noAuth() {
        return new Result<>(ErrorCode.AUTHENTICATE_FAIL, "请登录~", null);
    }

    public static Result<?> noAuth(String msg) {
        return new Result<>(ErrorCode.AUTHENTICATE_FAIL, msg, null);
    }

    public static Result<?> noPermission() {
        return new Result<>(ErrorCode.FAIL, "没有权限~", null);
    }

    public static class MapResult extends Result<Map<String, Object>> {
        public MapResult data(String key, Object value) {
            this.getData().put(key, value);
            return this;
        }
    }
}
