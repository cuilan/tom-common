package cn.cuilan.tom.constants;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 同一业务异常
 *
 * @author zhang.yan
 * @since 2021/10/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 错误码异常
     *
     * @param errorCode 错误码
     */
    public BaseException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
    }

    /**
     * 标准失败(10001)
     *
     * @param msg 自定义消息
     */
    public BaseException(String msg) {
        super(msg);
        this.code = ErrorCode.FAIL.getCode();
    }

    /**
     * 自定义异常
     *
     * @param code 自定义错误码
     * @param msg  自定义消息
     */
    public BaseException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

}

