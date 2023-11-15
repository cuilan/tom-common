package io.github.cuilan.tom.redis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * Redis 缓存服务
 *
 * @author zhangyan
 * @since 2021/12/20
 */
public abstract class AbstractRedisService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements CachedService<T> {

    @Override
    public T getCacheById(long id) {
        return null;
    }

    @Override
    public List<T> getCacheListByIds(Collection<Long> ids) {
        return null;
    }

    @Override
    public Map<Long, T> getCacheMapByIds(Collection<Long> ids) {
        return null;
    }

    @Override
    public void clearCache() {
    }

    @Override
    public void saveOrUpdateCache(Long id, T t) {
    }

    @Override
    public ConcurrentMap<String, T> getAllCache() {
        return null;
    }

    @Override
    public T daoGet(Long id) {
        return CachedService.super.daoGet(id);
    }
}
