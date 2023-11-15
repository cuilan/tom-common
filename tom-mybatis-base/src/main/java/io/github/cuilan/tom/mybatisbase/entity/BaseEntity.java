package io.github.cuilan.tom.mybatisbase.entity;

import io.github.cuilan.tom.mybatisbase.enums.Action;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 数据库实体基类
 *
 * @author zhang.yan
 * @since 2021-10-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseEntity extends BaseIdEntity implements Serializable {

    /**
     * 记录状态
     */
    private Action action;

    /**
     * 记录修改时间
     */
    private Long actionTime;

    /**
     * 记录创建时间
     */
    private Long createTime;

    /**
     * 设置action参数
     *
     * @param action action
     */
    public void setAction(Action action) {
        long now = System.currentTimeMillis();
        if (Action.INIT == action) {
            this.createTime = now;
        }
        this.actionTime = now;
        this.action = action;
    }

}
