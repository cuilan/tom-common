package cn.cuilan.tom.redis;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

/**
 * RedisKey转换器
 *
 * @author zhangyan
 * @since 2022/1/20
 */
@Getter
public class RedisKeyWrapper implements IRedisKeyWrapper {

    private final String appName = getAppName();

    private final String serviceName;

    private final String businessName;

    private final String desc;

    private final RedisDataType type;

    private int expireTime = -1;

    private TimeUnit expireUnit;

    public RedisKeyWrapper(String serviceName, String businessName, String desc, RedisDataType type) {
        this(serviceName, businessName, desc, type, -1, null);
    }

    public RedisKeyWrapper(String serviceName, String businessName, String desc, RedisDataType type, int expireTime, TimeUnit expireUnit) {
        this.serviceName = serviceName;
        this.businessName = businessName;
        this.desc = desc;
        this.type = type;
        this.expireTime = expireTime;
        this.expireUnit = expireUnit;
    }

    public RedisKeyWrapper setExpire(int expireTime, TimeUnit expireUnit) {
        this.expireTime = expireTime;
        this.expireUnit = expireUnit;
        return this;
    }
}
