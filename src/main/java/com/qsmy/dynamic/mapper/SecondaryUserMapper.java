package com.qsmy.dynamic.mapper;

import com.qsmy.dynamic.annotation.DataSource;
import com.qsmy.dynamic.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author qsmy
 * @date 2019/9/28
 */
@Component
@Mapper
public interface SecondaryUserMapper {
    @DataSource("secondary")
    @Select(value = "select * from user")
    List<User> findAll();
}
