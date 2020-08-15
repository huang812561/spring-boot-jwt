package com.jwt.services.user;

import com.jwt.config.JwtParam;
import com.jwt.constants.BusinessMessageEnum;
import com.jwt.constants.ResponseData;
import com.jwt.dao.user.UserMapper;
import com.jwt.entity.UserEntity;
import com.jwt.entity.UserLoginParam;
import com.jwt.utils.JwtUtils;
import com.jwt.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Decription：用户服务
 * @Author： huang_guoqiang
 * @Date 2019年05月10日 17:48
 * @Version 1.0
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private JwtParam jwtParam;
    @Autowired
    private UserMapper userMapper;

    /**
     * 登录校验
     * @param userParam
     * @return
     */
    public ResponseData login(UserLoginParam userParam){

        UserEntity userEntity = userMapper.queryUserByName(userParam.getUserName());
        if(userEntity != null){
            if(StringUtils.isNotEmpty(userEntity.getPassword())
                    && userEntity.getPassword().equals(MD5Util.getMD5(userParam.getPassword()))){
                //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
                Map<String,Object> claims = new HashMap<>();
                claims.put("uid", userEntity.getId());
                claims.put("user_name", userEntity.getUserName());
                claims.put("nick_name", userEntity.getPhone());
                claims.put("phone", userEntity.getPhone());
                String token = JwtUtils.createToken(userEntity.getId() + "", claims, jwtParam);
                if (StringUtils.isEmpty(token)) {
                    log.error("--------用户签名失败----------");
                    return ResponseData.failure(BusinessMessageEnum.LOGIN_SIGNED_ERR.getCode(),BusinessMessageEnum.LOGIN_SIGNED_ERR.getMsg());
                }
                log.info("===== 用户{}生成签名{} =====", userEntity.getId(), token);
                return ResponseData.success(token);
            }else{
                return ResponseData.failure(BusinessMessageEnum.LOGIN_PWD_ERR.getCode(),BusinessMessageEnum.LOGIN_PWD_ERR.getMsg());
            }

        }else {
            return ResponseData.failure(BusinessMessageEnum.LOGIN_USERNAME_NOT_EXIST.getCode(),BusinessMessageEnum.LOGIN_USERNAME_NOT_EXIST.getMsg());
        }

    }
}
