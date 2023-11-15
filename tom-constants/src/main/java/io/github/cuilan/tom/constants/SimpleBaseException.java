package io.github.cuilan.tom.constants;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 简易业务异常
 *
 * @author zhang.yan
 * @since 2022/04/06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SimpleBaseException extends RuntimeException {

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 简易状态码构造器
     *
     * @param simpleErrorCode 简易状态码
     */
    public SimpleBaseException(SimpleErrorCode simpleErrorCode) {
        super(simpleErrorCode.getShowMsg());
        this.code = simpleErrorCode.getCode();
    }

    /**
     * 自定义消息构造器
     *
     * @param msg 自定义消息
     */
    public SimpleBaseException(String msg) {
        super(msg);
        this.code = SimpleErrorCode.FAIL.getCode();
    }

    /**
     * 自定义状态码、自定义消息构造器
     *
     * @param code 自定义状态码
     * @param msg  自定义消息
     */
    public SimpleBaseException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

}

