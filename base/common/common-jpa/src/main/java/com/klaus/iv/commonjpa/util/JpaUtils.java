package com.klaus.iv.commonjpa.util;

import com.klaus.iv.commonbase.exceptions.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.annotation.Transient;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class JpaUtils {

    private JpaUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 获取所有属性，包括父类属性
     *
     * @param entityClass 业务实体类
     * @return 属性列表
     */
    public static List<Field> getAllFields(Class<?> entityClass) {
        Field[] fields = entityClass.getDeclaredFields();
        return getAllFields(entityClass.getSuperclass(), new ArrayList<>(Arrays.asList(fields)));
    }

    private static List<Field> getAllFields(Class<?> entityClass, List<Field> fields) {
        if (Object.class.equals(entityClass)) {
            //排除Transient
            Iterator<Field> it = fields.iterator();
            while (it.hasNext()) {
                Field next = it.next();
                if ("serialVersionUID".equals(next.getName())) {
                    it.remove();
                    continue;
                }
                if (null != next.getAnnotation(Transient.class)) {
                    it.remove();
                }
            }

            return fields;
        }
        Collections.addAll(fields, entityClass.getDeclaredFields());
        return getAllFields(entityClass.getSuperclass(), fields);
    }


    /**
     * 获取主键属性
     *
     * @param entityClass 业务实体类
     * @return 主键属性
     * @ {@inheritDoc}
     */
    public static Field getIdField(Class<?> entityClass) throws BaseException {
        for (Class<?> c = entityClass; c != Object.class; c = c.getSuperclass()) {
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                if (null != field.getAnnotation(Id.class)) {
                    return field;
                }
            }
        }
        throw new BaseException("Id field is not found in[" + entityClass + "]" + entityClass.getName());
    }

    /**
     * 获取主键值
     *
     * @param po 获取po的主键值
     * @return 主键值
     * @
     */
    public static Object gtIdValue(Object po) throws BaseException {
        if (null == po) {
            return null;
        }
        return getValue(po, getIdField(po.getClass()));
    }

    /**
     * 反射调用get方法
     *
     * @param po        对象
     * @param fieldName 属性名
     * @return 返回属性值
     * @ {@inheritDoc}
     */
    public static Object getValue(Object po, String fieldName) {
        if (null == po || StringUtils.isEmpty(fieldName)) {
            throw new BaseException("parameter is null");
        }
        try {
            Field field = getField(po.getClass(), fieldName);
            field.setAccessible(true);
            return field.get(po);
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
    }


    /**
     * 获取类及父类的属性
     *
     * @param clazz     类
     * @param fieldName 字段
     * @return 字段
     */
    public static Field getField(Class clazz, String fieldName) throws BaseException {
        if (clazz == Object.class) {
            throw new BaseException("class does not have this field :" + fieldName);
        }
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        return getField(clazz.getSuperclass(), fieldName);

    }


    /**
     * 已知对象的field时获取对象的值 add by limiao 20160215
     *
     * @param source 具体对象
     * @param field  字段
     * @return Object 值
     */
    public static Object getValue(Object source, Field field) {
        try {
            field.setAccessible(true);
            return field.get(source);
        } catch (Exception e) {
            log.error("JpaUtils getValue 异常！", e);
            return null;
        }
    }

    /**
     * 设置属性值
     *
     * @param source    对象
     * @param fieldName 属性名
     * @param value     属性值
     * @ {@inheritDoc}
     */
    public static void setValue(Object source, String fieldName, Object value) {
        if (null == source || StringUtils.isEmpty(fieldName)) {
            throw new BaseException("parameter is null");
        }
        try {
            Field field = getField(source.getClass(), fieldName);
            field.setAccessible(true);
            field.set(source, value);
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }

    }


    /**
     * 判断一个field是否是string类型
     * add by limiao 20160216
     *
     * @param field field对象
     * @return boolean
     */
    public static boolean fieldIsStringType(Field field) {
        return field.getType().equals(String.class);
    }

    /**
     * 判断一个field是否是date类型
     * add by limiao 20160216
     *
     * @param field field对象
     * @return boolean
     */
    public static boolean fieldIsDateType(Field field) {
        return field.getType().equals(Date.class);
    }

    /**
     * 返回一个map,key是id，value是propertyName的值
     *
     * @param propertyName     属性名
     * @param entityCollection 对象集合
     * @param <T>              泛型
     * @return idPropertyMap
     */
    public static <T> Map<String, Object> getIdPropertyMap(String propertyName, Collection<T> entityCollection) {
        Map<String, Object> result = new LinkedHashMap<>();
        if (CollectionUtils.isNotEmpty(entityCollection)) {
            for (T entity : entityCollection) {
                try {
                    Field idField = getIdField(entity.getClass());
                    idField.setAccessible(true);
                    Object propertyObj = getValue(entity, entity.getClass().getDeclaredField(propertyName));
                    result.put((String) idField.get(entity), propertyObj);
                } catch (Exception e) {
                    log.error("JpaUtils getValue 异常！", e);
                    return null;
                }
            }
        }
        return result;
    }

    /**
     * 返回一个map,key是id,value是对象本身
     *
     * @param entityCollection 对象集合
     * @param <T>              泛型
     * @return id对象Map
     */
    public static <T> Map<String, T> getIdEntityMap(Collection<T> entityCollection) throws BaseException {
        Map<String, T> result = new LinkedHashMap<>();
        if (CollectionUtils.isNotEmpty(entityCollection)) {
            for (T entity : entityCollection) {
                try {
                    Field idField = getIdField(entity.getClass());
                    result.put((String) getValue(entity, idField), entity);
                } catch (BaseException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 接收一个po，获取一个以的数据库列名为key，以属性值为value的map
     *
     * @param po po
     */
    public static Map<String, Object> getColumnNameValueMap(Object po) {
        Assert.notNull(po, "po is required");
        List<Field> list = getAllFields(po.getClass());
        Map<String, Object> map = new HashMap<>(list.size());
        for (Field field : list) {
            Column annotation = field.getAnnotation(Column.class);
            if (annotation == null) {
                continue;
            }
            field.setAccessible(true);
            String name = StringUtils.isEmpty(annotation.name()) ? field.getName() : annotation.name();
            try {
                map.put(name, field.get(po));
            } catch (IllegalAccessException e) {
                log.error("获取属性值失败", e);
            }
        }
        return map;
    }
}
