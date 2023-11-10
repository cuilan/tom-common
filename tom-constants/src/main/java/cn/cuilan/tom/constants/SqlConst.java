package cn.cuilan.tom.constants;

/**
 * sql 语句常量
 *
 * @author zhangyan
 * @since 2021/12/20
 */
public class SqlConst {

    public static final String FILED_ID = "id";
    public static final String FILED_ACTION = "action";
    public static final String FILED_CREATE_TIME = "create_time";
    public static final String FILED_UPDATE_TIME = "update_time";

    public static final String SELECT = "select ";
    public static final String SELECT_ALL = "select * from ";
    public static final String SELECT_COUNT = "select count(*) from ";

    public static final String UPDATE = "update ";
    public static final String DELETE_FROM = "delete from ";

    public static final String JOIN = "join ";
    public static final String INNER_JOIN = "inner join ";
    public static final String OUTER_JOIN = "outer join ";
    public static final String LEFT_JOIN = "left join ";
    public static final String RIGHT_JOIN = "right join ";

    public static final String GROUP_BY = "group by ";

    public static final String ORDER_BY = "order by ";
    public static final String ASC = "asc";
    public static final String DESC = "desc";

    public static final String LIMIT = "limit ";
    public static final String LIMIT_ONE = "limit 1";
    public static final String LIMIT_TEN = "limit 10";

    public static final String FOR_UPDATE_LOCK = "for update ";

}
