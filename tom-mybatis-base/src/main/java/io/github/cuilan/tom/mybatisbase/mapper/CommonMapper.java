package io.github.cuilan.tom.mybatisbase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;

/**
 * Mybatis-plus 公共基础父类
 *
 * @author zhangyan
 * @since 2021/12/20
 */
public interface CommonMapper<T> extends BaseMapper<T> {

    boolean saveBatch(Collection<T> entityList);

    boolean saveBatch(Collection<T> entityList, int batchSize);

    boolean updateBatchById(Collection<T> entityList);

    boolean updateBatchById(Collection<T> entityList, int batchSize);

    boolean saveOrUpdateBatch(Collection<T> entityList);

    boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize);

}
