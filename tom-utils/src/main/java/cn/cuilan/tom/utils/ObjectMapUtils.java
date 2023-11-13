package cn.cuilan.tom.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 对象、map互转工具
 *
 * @author zhangyan
 * @since 2022/08/03
 */
public class ObjectMapUtils {

    /**
     * 将对象转为 Map&lt;String, Object$gt; 类型，如果对象各字段都为空，则返回 null
     *
     * @param obj 源对象
     * @return Map&lt;String, Object$gt; 字段名为key，字段值为value的map
     * @throws IllegalAccessException 对象可能禁止暴露破解字段，或无法访问
     */
    public static Map<String, Object> getObjectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> cla = obj.getClass();
        Field[] fields = cla.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String keyName = field.getName();
            Object value = field.get(obj);
            if (value == null) {
                continue;
            }
            map.put(keyName, value);
        }
        if (!map.isEmpty()) {
            return map;
        }
        return null;
    }

}
