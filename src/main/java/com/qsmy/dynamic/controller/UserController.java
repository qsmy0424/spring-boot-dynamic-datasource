package com.qsmy.dynamic.controller;

import com.qsmy.dynamic.entity.User;
import com.qsmy.dynamic.mapper.PrimaryUserMapper;
import com.qsmy.dynamic.mapper.SecondaryUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qsmy
 * @date 2019/9/28
 */
@RestController
public class UserController {

    @Autowired
    private PrimaryUserMapper primaryUserMapper;
    @Autowired
    private SecondaryUserMapper secondaryUserMapper;

    @RequestMapping("/primary")
    public List<User> primary() {
        return primaryUserMapper.findAll();
    }

    @RequestMapping("/secondary")
    public List<User> secondary() {
        return secondaryUserMapper.findAll();
    }
}
