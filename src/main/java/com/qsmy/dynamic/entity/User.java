package com.qsmy.dynamic.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qsmy
 * @date 2019-03-26 17:05
 */
@Data
public class User {

    private Long id;

    private String username;

    private String password;

    private String roleName;

    private boolean locked;
}
