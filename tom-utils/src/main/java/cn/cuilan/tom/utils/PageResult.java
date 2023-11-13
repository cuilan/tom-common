package cn.cuilan.tom.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页结果集
 *
 * @param <T> 泛型T
 * @author zhangyan
 * @since 2023/11/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResult<T> {

    /**
     * 泛型T类型的List
     */
    public List<T> list;

    /**
     * 分页参数对象
     */
    public Pagination pagination;
}
