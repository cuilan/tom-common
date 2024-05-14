package io.github.cuilan.tom.redis;

import io.github.cuilan.tom.constants.BaseException;
import io.github.cuilan.tom.constants.ErrorCode;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * 公共缓存服务
 *
 * @author zhangyan
 * @since 2021/12/20
 */
public interface CachedService<T> extends IService<T> {

    /**
     * 根据id查询，缓存中不存在，则查库
     *
     * @param id id
     * @return T 实体对象
     */
    T getCacheById(long id);

    /**
     * 根据id删除缓存
     *
     * @param id id
     */
    void removeCacheById(Long id);

    /**
     * 根据自定义key查询，缓存中不存在，则需要子类覆盖daoGet方法，实现查询逻辑
     *
     * @param key 自定义key
     * @return T 实体对象
     */
    T getCacheByKey(String key);

    /**
     * 根据自定义key删除缓存
     *
     * @param key key
     */
    void removeCacheByKey(String key);

    /**
     * 查询id集合，缓存中不存在，则查库
     *
     * @param ids ids
     * @return 返回对象List
     */
    List<T> getCacheListByIds(Collection<Long> ids);

    /**
     * 查询自定义key集合，缓存中不存在，则查库
     *
     * @param keys keys
     * @return 返回对象List
     */
    List<T> getCacheListByKeys(Collection<String> keys);

    /**
     * 查询id集合，缓存中不存在，则插库
     *
     * @param ids ids
     * @return 返回对象Map，key：主键，value：实体对象
     */
    Map<Long, T> getCacheMapByIds(Collection<Long> ids);

    /**
     * 查询自定义key集合，缓存中不存在，则插库
     *
     * @param keys keys
     * @return 返回对象Map，key：主键，value：实体对象
     */
    Map<String, T> getCacheMapByKeys(Collection<String> keys);

    /**
     * 清除缓存
     */
    void clearCache();

    /**
     * 保存或更新缓存对象，对单个对象修改后，无需清空缓存
     *
     * @param id id
     * @param t  实体对象
     */
    void saveOrUpdateCache(Long id, T t);

    /**
     * 保存或更新缓存对象，对单个对象修改后，无需清空缓存
     *
     * @param key key
     * @param t   实体对象
     */
    void saveOrUpdateCache(String key, T t);

    /**
     * 查询所有Long类型id的缓存
     *
     * @return 实体对象集合
     */
    List<T> getAllCacheById();

    /**
     * 查询所有String类型自定义key的缓存
     *
     * @return 实体对象集合
     */
    List<T> getAllCacheByKey();

    /**
     * 获取所有Long类型自定义key的缓存
     *
     * @return ConcurrentMap&lt;Long, T&gt;
     */
    ConcurrentMap<Long, T> getAllCacheMapById();

    /**
     * 获取所有String类型自定义key的缓存
     *
     * @return ConcurrentMap&lt;String, T&gt;
     */
    ConcurrentMap<String, T> getAllCacheMapByKey();

    /**
     * 缓存中不存在时，默认执行此方法
     *
     * @param id id
     * @return 返回实体对象
     */
    default T daoGet(Long id) {
        return this.getBaseMapper().selectById(id);
    }

    /**
     * 缓存中不存在时，默认执行此方法
     *
     * @param key 自定义key
     * @return 返回实体对象
     */
    default T daoGetByKey(String key) {
        // 需要子类自定义实现
        throw new BaseException(ErrorCode.CACHE_SERVICE_UNAVAILABLE);
    }

    /**
     * 缓存中不存在时，默认执行此方法
     *
     * @param collection id集合
     * @return 返回实体对象集合
     */
    default List<T> daoGetByIdList(Collection<Long> collection) {
        // 需要子类自定义实现
        throw new BaseException(ErrorCode.CACHE_SERVICE_UNAVAILABLE);
    }

}
