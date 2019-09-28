package com.qsmy.dynamic.config;

import java.util.Optional;

/**
 * @author qsmy
 * @date 2019/9/28
 */
public class DataSourceType {

    // 内部枚举类，用于选择特定的数据类型
    public enum DataBaseType {
        PRIMARY, SECONDARY
    }

    // 使用ThreadLocal保证线程安全
    private static final ThreadLocal<DataBaseType> TYPE = new ThreadLocal<>();

    // 往当前线程里设置数据源类型
    public static void setDatabaseType(DataBaseType databaseType) {
        Optional.ofNullable(databaseType).ifPresent(TYPE::set);
    }

    // 获取数据源类型
    public static DataBaseType getDatabaseType() {
        return TYPE.get() == null ? DataBaseType.PRIMARY : TYPE.get();
    }

    // 清空数据源类型
    public static void clearDataBaseType() {
        TYPE.remove();
    }
}
