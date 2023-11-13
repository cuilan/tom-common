package cn.cuilan.tom.constants;

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

    public SimpleBaseException(SimpleErrorCode simpleErrorCode) {
        super(simpleErrorCode.getShowMsg());
        this.code = simpleErrorCode.getCode();
    }

    public SimpleBaseException(String msg) {
        super(msg);
        this.code = SimpleErrorCode.FAIL.getCode();
    }

    public SimpleBaseException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

}

