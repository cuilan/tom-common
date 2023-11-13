package cn.cuilan.tom.mybatisbase.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * 数据库表数据记录状态
 */
@Getter
public enum Action implements IEnum<Integer> {

    INIT(0, "初始状态"),

    UPDATED(1, "已修改状态"),

    DELETED(2, "已删除状态");

    private final Integer code;

    private final String desc;

    Action(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return code;
    }

}
