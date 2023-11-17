package io.github.cuilan.tom.mybatisbase.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数据库租户实体基类
 *
 * @author zhangyan
 * @since 2023/11/17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseTenantEntity extends BaseEntity {

    /**
     * 租户id
     */
    private Long tenantId;

}
