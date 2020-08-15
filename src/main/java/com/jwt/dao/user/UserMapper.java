package com.jwt.dao.user;

import com.jwt.dao.base.BaseMapper;
import com.jwt.entity.UserEntity;

/**
 * @Decription：
 * @Author： huang_guoqiang
 * @Date 2019年05月10日 17:50
 * @Version 1.0
 */
public interface UserMapper extends BaseMapper {

    UserEntity queryUserByName(String userName);
}
