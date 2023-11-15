package io.github.cuilan.tom.utils;

import io.github.cuilan.tom.constants.SimpleErrorCode;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 简易结果集
 *
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

    /**
     * 空参构造器
     */
    public SimpleResult() {
    }

    /**
     * 错误码构造器
     *
     * @param code SimpleErrorCode
     */
    public SimpleResult(SimpleErrorCode code) {
        if (code == null) {
            throw new NullPointerException("状态码为空");
        }
        this.code = code.getCode();
    }

    /**
     * 错误码、前端展示消息构造器
     *
     * @param code    SimpleErrorCode
     * @param showMsg 前端展示消息
     */
    public SimpleResult(SimpleErrorCode code, String showMsg) {
        this(code);
        this.showMsg = showMsg;
    }

    /**
     * 错误码、自定义数据
     *
     * @param code SimpleErrorCode
     * @param data 数据
     */
    public SimpleResult(SimpleErrorCode code, T data) {
        this(code);
        this.data = data;
    }

    /**
     * 错误码、前端展示消息、自定义数据构造器
     *
     * @param code    SimpleErrorCode
     * @param showMsg 前端展示消息
     * @param data    数据
     */
    public SimpleResult(SimpleErrorCode code, String showMsg, T data) {
        this(code, data);
        this.showMsg = showMsg;
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
        result.setCode(SimpleErrorCode.SUCCESS.code);
        return result;
    }

    /**
     * 返回map格式的结果集，默认状态码为成功，自定义消息
     *
     * @param msg 自定义消息
     * @return MapResult
     */
    public static MapResult map(String msg) {
        return map(SimpleErrorCode.SUCCESS.code, msg);
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
        result.setShowMsg(msg);
        result.setData(map);
        result.setCode(code);
        return result;
    }

    /**
     * MapResult 类，继承 Result
     *
     * @author zhangyan
     * @since 2023/11/13
     */
    public static class MapResult extends SimpleResult<Map<String, Object>> {

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

    // ========== static ==========

    /**
     * 普通成功仅返回状态
     *
     * @return SimpleResult SUCCESS
     */
    public static SimpleResult<?> success() {
        return new SimpleResult<>(SimpleErrorCode.SUCCESS, null);
    }

    /**
     * 返回成功状态及描述信息
     *
     * @param msg 自定义消息
     * @return SimpleResult SUCCESS
     */
    public static SimpleResult<?> success(String msg) {
        return new SimpleResult<>(SimpleErrorCode.SUCCESS, msg, null);
    }

    /**
     * 仅返回成功数据
     *
     * @param data 自定义数据
     * @return SimpleResult SUCCESS
     */
    public static SimpleResult<?> success(Object data) {
        return new SimpleResult<>(SimpleErrorCode.SUCCESS, data);
    }

    /**
     * 成功
     *
     * @param msg  自定义消息
     * @param data 自定义数据
     * @return SimpleResult SUCCESS
     */
    public static SimpleResult<?> success(String msg, Object data) {
        return new SimpleResult<>(SimpleErrorCode.SUCCESS, msg, data);
    }

    /**
     * 失败
     *
     * @param code 自定义错误码
     * @param msg  自定义消息
     * @return SimpleResult
     */
    public static SimpleResult<?> fail(Integer code, String msg) {
        SimpleResult<Object> simpleResult = new SimpleResult<>();
        simpleResult.setCode(code);
        simpleResult.setMsg(msg);
        simpleResult.setShowMsg(msg);
        return simpleResult;
    }

    /**
     * 失败
     *
     * @param msg 自定义消息
     * @return SimpleResult FAIL
     */
    public static SimpleResult<?> fail(String msg) {
        return new SimpleResult<>(SimpleErrorCode.FAIL, msg, null);
    }

    /**
     * 失败
     *
     * @param msg  自定义消息
     * @param data 自定义数据
     * @return SimpleResult FAIL
     */
    public static SimpleResult<?> fail(String msg, Object data) {
        return new SimpleResult<>(SimpleErrorCode.FAIL, msg, data);
    }

    /**
     * 失败
     *
     * @param code 自定义错误码
     * @param msg  自定义消息
     * @param data 自定义数据
     * @return SimpleResult FAIL
     */
    public static SimpleResult<?> fail(Integer code, String msg, Object data) {
        return new SimpleResult<>(new SimpleErrorCode(code, msg), data);
    }

    /**
     * 401 认证失败
     *
     * @return SimpleResult AUTH_FAIL
     */
    public static SimpleResult<?> noAuth() {
        return new SimpleResult<>(SimpleErrorCode.AUTH_FAIL, "请登录~", null);
    }

    /**
     * 401 认证失败
     *
     * @param msg 自定义消息
     * @return SimpleResult AUTH_FAIL
     */
    public static SimpleResult<?> noAuth(String msg) {
        return new SimpleResult<>(SimpleErrorCode.AUTH_FAIL, msg, null);
    }

    /**
     * 没有权限
     *
     * @return SimpleResult FAIL
     */
    public static SimpleResult<?> noPermission() {
        return new SimpleResult<>(SimpleErrorCode.FAIL, "没有权限~", null);
    }
}
