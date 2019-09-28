package com.qsmy.dynamic.aop;

import com.qsmy.dynamic.config.DataSourceType;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author qsmy
 * @date 2019/9/28
 */
// @Aspect
@Component
public class DataSourceAop {

    @Before("execution(* com.qsmy.dynamic.controller.UserController.primary())")
    public void setDatasource1() {
        DataSourceType.setDatabaseType(DataSourceType.DataBaseType.PRIMARY);
    }

    @Before("execution(* com.qsmy.dynamic.controller.UserController.secondary())")
    public void setDataSource2() {
        DataSourceType.setDatabaseType(DataSourceType.DataBaseType.SECONDARY);
    }
}
