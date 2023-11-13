package cn.cuilan.tom.mybatisbase.service;

import cn.cuilan.tom.constants.BaseException;
import cn.cuilan.tom.constants.ErrorCode;
import cn.cuilan.tom.constants.IntConst;
import cn.cuilan.tom.constants.SqlConst;
import cn.cuilan.tom.mybatisbase.entity.BaseEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
import java.util.List;

/**
 * 公共服务层接口
 *
 * @author zhangyan
 * @since 2021/12/20
 */
public interface CommonService<T extends BaseEntity> extends IService<T> {

    /**
     * 获取当前最大id
     *
     * @return 返回long类型id
     */
    default long getMaxId() {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc(SqlConst.FILED_ID);
        wrapper.last(SqlConst.LIMIT_ONE);
        T entity = this.getBaseMapper().selectOne(wrapper);
        if (entity != null) {
            return entity.getId();
        }
        return 0L;
    }

    /**
     * 根据id查询对象，如果不存在抛出异常
     *
     * @param id id
     * @return 实体对象
     */
    default T getNotNull(long id) {
        // 参数校验
        if (id <= 0L) {
            throw new BaseException("id不合法");
        }
        T t = this.getBaseMapper().selectById(id);
        if (t == null) {
            throw new BaseException(ErrorCode.DATA_NOT_EXIST_ERROR);
        }
        return t;
    }

    /**
     * 获取最新的一条数据
     *
     * @return 最后一条数据记录
     */
    default T queryLast() {
        return queryLast(IntConst.INT_ONE);
    }

    /**
     * 获取最新的 N 条数据
     *
     * @param limit 分页参数
     * @return 最后 N 条数据记录
     */
    default T queryLast(int limit) {
        return queryLastByFiled(SqlConst.FILED_CREATE_TIME, limit);
    }

    /**
     * 根据指定字段获取最新的 N 条数据
     *
     * @param filed 字段名称
     * @param limit 分页参数
     * @return 最后 N 条数据记录
     */
    default T queryLastByFiled(String filed, int limit) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc(filed);
        wrapper.last(SqlConst.LIMIT + limit);
        return this.getBaseMapper().selectOne(wrapper);
    }

    /**
     * 公共接口默认方法，按 id 分页查询对象
     *
     * @param offset 起始id
     * @param limit  分页大小
     * @return 返回实体对象集合
     */
    default List<T> queryByPage(long offset, long limit) {
        if (limit <= 0L) {
            return new ArrayList<>();
        }
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.gt(SqlConst.FILED_ID, offset);
        wrapper.orderByAsc(SqlConst.FILED_ID);
        wrapper.last(SqlConst.LIMIT + limit);
        return this.getBaseMapper().selectList(wrapper);
    }

}
