package cn.cuilan.tom.mybatis.base;

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
    private Integer action;

    /**
     * 记录修改时间
     */
    private Long actionTime;

    /**
     * 记录创建时间
     */
    private Long createTime;

}
