package com.qsmy.dynamic.aop;

import com.qsmy.dynamic.annotation.DataSource;
import com.qsmy.dynamic.config.Constants;
import com.qsmy.dynamic.config.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author qsmy
 * @date 2019/9/28
 */
@Aspect
@Component
@Slf4j
public class DynamicDataSourceAspect {

    // 拦截注解
    @Before("@annotation(dataSource)")
    public void changeDataSource(DataSource dataSource) {
        String value = dataSource.value();
        if (Constants.DATASOURCE_TYPE_SECOND.equals(value)) {
            DataSourceType.setDatabaseType(DataSourceType.DataBaseType.SECONDARY);
        } else {
            DataSourceType.setDatabaseType(DataSourceType.DataBaseType.PRIMARY);
        }
    }

    @After("@annotation(dataSource)")
    public void resetDatabase(DataSource dataSource) {
        DataSourceType.clearDataBaseType();
    }

}
