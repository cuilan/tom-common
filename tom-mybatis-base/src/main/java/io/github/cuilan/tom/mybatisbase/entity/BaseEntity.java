package io.github.cuilan.tom.mybatisbase.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 数据库实体基类
 *
 * @author zhangyan
 * @since 2023/11/9
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseEntity extends BaseTimeEntity implements Serializable {

    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

}
