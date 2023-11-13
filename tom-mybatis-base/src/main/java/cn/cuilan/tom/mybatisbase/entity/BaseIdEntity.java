package cn.cuilan.tom.mybatisbase.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 数据库实体基类
 *
 * @author zhangyan
 * @since 2023/11/9
 */
@Data
public class BaseIdEntity implements Serializable {

    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

}
