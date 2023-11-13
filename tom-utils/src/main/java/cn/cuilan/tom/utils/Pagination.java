package cn.cuilan.tom.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pagination {

    /**
     * 当前页码
     */
    private Long current;

    /**
     * 分页大小
     */
    private Long pageSize;

    /**
     * 总数
     */
    private Long total;

    /**
     * 总页数
     */
    private Long totalPage;
}
