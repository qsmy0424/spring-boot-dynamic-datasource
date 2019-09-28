package com.qsmy.dynamic.annotation;
import java.lang.annotation.*;

/**
 * @author qsmy
 * @date 2019/9/28
 */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String value() default "primary";
}
