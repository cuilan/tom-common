package io.github.cuilan.tom.utils;

import io.github.cuilan.tom.constants.ErrorCode;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局返回结果
 *
 * @param <T> Object
 * @author zhangyan
 * @since 2023/11/13
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

    /**
     * 空参构造器
     */
    public Result() {
    }

    /**
     * ErrorCode错误码构造器
     *
     * @param code 错误码
     */
    public Result(ErrorCode code) {
        if (code == null) {
            throw new NullPointerException("状态码为空");
        }
        this.code = code.getCode();
    }

    /**
     * ErrorCode、自定义数据构造器
     *
     * @param code ErrorCode错误码
     * @param data 数据
     */
    public Result(ErrorCode code, T data) {
        this(code);
        this.data = data;
    }

    /**
     * ErrorCode、自定义消息、数据构造器
     *
     * @param code ErrorCode错误码
     * @param msg  自定义消息
     * @param data 数据
     */
    public Result(ErrorCode code, String msg, T data) {
        this(code, data);
        this.msg = msg;
    }

    /**
     * ErrorCode、自定义消息构造器
     *
     * @param code ErrorCode错误码
     * @param msg  自定义消息
     */
    public Result(ErrorCode code, String msg) {
        this.code = code.code;
        this.msg = msg;
    }

    // ========== MapResult ==========

    /**
     * 返回map格式的结果集，默认状态码为成功
     * <code>
     * Result.map().data("key", null);
     * </code>
     *
     * @return MapResult
     */
    public static MapResult map() {
        MapResult result = new MapResult();
        Map<String, Object> map = new HashMap<>();
        result.setData(map);
        result.setCode(ErrorCode.SUCCESS.code);
        return result;
    }

    /**
     * 返回map格式的结果集，默认状态码为成功，自定义消息
     *
     * @param msg 自定义消息
     * @return MapResult
     */
    public static MapResult map(String msg) {
        return map(ErrorCode.SUCCESS.code, msg);
    }

    /**
     * 返回map格式的结果集，自定义状态码和消息
     *
     * @param code 自定义错误码
     * @param msg  自定义消息
     * @return MapResult
     */
    public static MapResult map(Integer code, String msg) {
        MapResult result = new MapResult();
        Map<String, Object> map = new HashMap<>();
        result.setMsg(msg);
        result.setData(map);
        result.setCode(code);
        return result;
    }

    /**
     * 返回map格式的结果集，将 Map 数据装换为 MapResult
     *
     * @param dateMap Map数据
     * @return MapResult
     */
    public static MapResult map(Map<String, Object> dateMap) {
        MapResult result = new MapResult();
        result.setData(dateMap);
        result.setCode(ErrorCode.SUCCESS.code);
        return result;
    }

    // ========== static ==========

    /**
     * 普通成功仅返回状态
     *
     * @return SUCCESS
     */
    public static Result<?> success() {
        return new Result<>(ErrorCode.SUCCESS, null);
    }

    /**
     * 返回成功状态及描述信息
     *
     * @param msg 自定义消息
     * @return SUCCESS
     */
    public static Result<?> success(String msg) {
        return new Result<>(ErrorCode.SUCCESS, msg, null);
    }

    /**
     * 仅返回成功数据
     *
     * @param data 数据
     * @return SUCCESS
     */
    public static Result<?> success(Object data) {
        return new Result<>(ErrorCode.SUCCESS, data);
    }

    /**
     * 成功
     *
     * @param msg  自定义消息
     * @param data 数据
     * @return SUCCESS
     */
    public static Result<?> success(String msg, Object data) {
        return new Result<>(ErrorCode.SUCCESS, msg, data);
    }

    /**
     * 失败
     *
     * @param code 自定义错误码
     * @param msg  自定义消息
     * @return Result
     */
    public static Result<?> fail(Integer code, String msg) {
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 失败
     *
     * @param msg 自定义消息
     * @return Result
     */
    public static Result<?> fail(String msg) {
        return new Result<>(ErrorCode.FAIL, msg, null);
    }

    /**
     * 失败
     *
     * @param msg  自定义消息
     * @param data 数据
     * @return Result
     */
    public static Result<?> fail(String msg, Object data) {
        return new Result<>(ErrorCode.FAIL, msg, data);
    }

    /**
     * 失败
     *
     * @param code 自定义错误码
     * @param msg  自定义消息
     * @param data 数据
     * @return Result
     */
    public static Result<?> fail(Integer code, String msg, Object data) {
        return new Result<>(new ErrorCode(code, msg), data);
    }

    /**
     * 认证失败
     *
     * @return Result
     */
    public static Result<?> noAuth() {
        return new Result<>(ErrorCode.AUTHENTICATE_FAIL, "请登录~", null);
    }

    /**
     * 认证失败
     *
     * @param msg 自定义消息
     * @return Result
     */
    public static Result<?> noAuth(String msg) {
        return new Result<>(ErrorCode.AUTHENTICATE_FAIL, msg, null);
    }

    /**
     * 没有权限
     *
     * @return Result
     */
    public static Result<?> noPermission() {
        return new Result<>(ErrorCode.FAIL, "没有权限~", null);
    }

    /**
     * MapResult 类，继承 Result
     *
     * @author zhangyan
     * @since 2023/11/13
     */
    public static class MapResult extends Result<Map<String, Object>> {

        /**
         * data 自定义数据
         *
         * @param key   key
         * @param value value
         * @return MapResult
         */
        public MapResult data(String key, Object value) {
            this.getData().put(key, value);
            return this;
        }
    }
}
