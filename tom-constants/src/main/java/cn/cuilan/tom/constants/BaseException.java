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

    public BaseException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
    }

    public BaseException(String msg) {
        super(msg);
        this.code = ErrorCode.FAIL.getCode();
    }

    public BaseException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

}

