package io.github.cuilan.tom.constants;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * OCCException 类表示与乐观并发控制（OCC）相关的异常。
 * 通常在进行 OCC 操作时遇到问题时抛出此异常。
 * 继承自 RuntimeException 类。
 *
 * @author zhangyan
 * @since 2023/12/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OCCException extends RuntimeException {

    /**
     * 构造一个新的 OCCException，没有指定详细消息。
     * 当遇到的问题不需要特定消息时，通常使用此构造器。
     */
    public OCCException() {
    }

    /**
     * 构造一个新的 OCCException，带有指定的详细消息。
     *
     * @param message 详细消息（稍后可通过 getMessage() 方法检索）
     */
    public OCCException(String message) {
        super(message);
    }

    /**
     * 构造一个新的 OCCException，带有指定的详细消息和原因。
     *
     * @param message 详细消息（稍后可通过 getMessage() 方法检索）
     * @param cause   原因（稍后可通过 getCause() 方法检索）
     */
    public OCCException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造一个新的 OCCException，带有指定的详细消息、原因、启用或禁用抑制以及启用或禁用可写堆栈跟踪。
     *
     * @param message            详细消息（稍后可通过 getMessage() 方法检索）
     * @param cause              原因（稍后可通过 getCause() 方法检索）
     * @param enableSuppression  是否启用抑制
     * @param writableStackTrace 是否启用可写堆栈跟踪
     */
    public OCCException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
