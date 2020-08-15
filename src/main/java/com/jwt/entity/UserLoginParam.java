package com.jwt.entity;

import lombok.Data;

/**
 * @Decription：登录用户请求参数
 * @Author： huang_guoqiang
 * @Date 2019年05月13日 13:46
 * @Version 1.0
 */
@Data
public class UserLoginParam {

    private String userName;
    private String password;

}
