package io.github.cuilan.tom.mybatisbase.entity;


import io.github.cuilan.tom.mybatisbase.enums.Action;

/**
 * 数据库实体帮助类 设置基本参数
 *
 * @author zhang.yan
 * @since 2020-07-23
 */
public final class EntityHelper {

    private EntityHelper() {
    }

    /**
     * 设置action参数
     *
     * @param item   实体类
     * @param action action
     */
    public static void setBaseInfo(BaseTimeEntity item, Action action) {
        Long now = System.currentTimeMillis();
        if (Action.INIT == action) {
            item.setCreateTime(now);
        }
        item.setActionTime(now);
        item.setAction(action);
    }
}