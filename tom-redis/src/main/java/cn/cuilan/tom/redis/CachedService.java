package cn.cuilan.tom.redis;

import cn.cuilan.tom.constants.BaseException;
import cn.cuilan.tom.constants.ErrorCode;
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
     * 根据自定义key查询，缓存中不存在，则需要子类覆盖daoGet方法，实现查询逻辑
     *
     * @param key 自定义key
     * @return T 实体对象
     */
    T getCacheByKey(String key);

    /**
     * 查询id集合，缓存中不存在，则查库
     *
     * @param ids ids
     * @return 返回对象List
     */
    List<T> getCacheListByIds(Collection<Long> ids);

    /**
     * 查询id集合，缓存中不存在，则插库
     *
     * @param ids ids
     * @return 返回对象Map，key：主键，value：实体对象
     */
    Map<Long, T> getCacheMapByIds(Collection<Long> ids);

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
     * 获取缓存中全部对象
     *
     * @return ConcurrentMap
     */
    ConcurrentMap<String, T> getAllCache();

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
    default T daoGet(String key) {
        // 需要子类自定义实现
        throw new BaseException(ErrorCode.CACHE_SERVICE_UNAVAILABLE);
    }
}
