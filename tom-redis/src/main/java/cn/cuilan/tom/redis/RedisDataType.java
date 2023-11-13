package cn.cuilan.tom.redis;

/**
 * Redis数据类型
 *
 * @author zhangyan
 * @since 2022/1/20
 */
public enum RedisDataType {

    // key-value
    KV,

    // hash
    HASH,

    // list
    LIST,

    // set
    SET,

    // sorted-set
    ZSET,

    // 自增
    INCR,

    // geo
    GEO,

    // bitmap
    BIT_MAP,

    // pub-sub
    PUB_SUB,

    // HyperLogLog
    HYPER_LOG_LOG;
}
