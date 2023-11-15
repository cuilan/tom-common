package io.github.cuilan.tom.redis;

import io.github.cuilan.tom.constants.StringConst;

import java.util.concurrent.TimeUnit;

/**
 * redisKey标准
 *
 * @author zhangyan
 * @since 2022/1/20
 */
public interface IRedisKeyWrapper {

    /**
     * 获取应用名称
     */
    String getAppName();

    /**
     * 获取服务名称
     */
    String getServiceName();

    /**
     * 获取业务名称
     */
    String getBusinessName();

    /**
     * 获取key描述
     */
    String getDesc();

    /**
     * 获取key类型
     */
    RedisDataType getType();

    /**
     * 获取过期时间
     */
    int getExpireTime();

    /**
     * 获取过期单位
     */
    TimeUnit getExpireUnit();

    /**
     * 检查参数
     */
    default void checkParams() {
        if (getServiceName() == null || getServiceName().isBlank()) {
            throw new RuntimeException("Redis key service name empty.");
        }
        if (getBusinessName() == null || getBusinessName().isBlank()) {
            throw new RuntimeException("Redis key business name empty.");
        }
        if (getDesc() == null || getDesc().isBlank()) {
            throw new RuntimeException("Redis key desc empty.");
        }
        if (null == getType()) {
            throw new RuntimeException("Redis key type null.");
        }
        if (getExpireTime() > 0) {
            if (null == getExpireUnit()) {
                throw new RuntimeException("Redis key expire unit null.");
            }
        }
    }

    /**
     * 获取完整key
     *
     * @param customerKey 用户自定义key
     * @return 返回完整key
     */
    default String getFullKey(String customerKey) {
        if (customerKey != null && !customerKey.isBlank()) {
            return String.join(StringConst.COLON_STR, getAppName(), getServiceName(), getBusinessName(), customerKey, getType().toString().toLowerCase());
        }
        return String.join(StringConst.COLON_STR, getAppName(), getServiceName(), getBusinessName(), getType().toString().toLowerCase());
    }

    /**
     * 获取超时时间秒数
     *
     * @return TTL，单位秒
     */
    default int getExpireTimeSeconds() {
        int expireTime = getExpireTime();
        if (expireTime <= 0) {
            return -1;
        }
        if (null == getExpireUnit()) {
            throw new RuntimeException("Redis key expire unit null.");
        }
        return Long.valueOf(TimeUnit.SECONDS.convert(expireTime, getExpireUnit())).intValue();
    }
}
