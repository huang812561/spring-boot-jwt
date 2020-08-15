package com.jwt.action;

import com.jwt.annotation.JwtIgnore;
import com.jwt.constants.BusinessMessageEnum;
import com.jwt.constants.RequestParam;
import com.jwt.constants.ResponseData;
import com.jwt.entity.UserLoginParam;
import com.jwt.services.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Decription：登录
 * @Author： huang_guoqiang
 * @Date 2019年05月05日 15:09
 * @Version 1.0
 */
@RestController
@Slf4j
public class LoginAction {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param userParam
     * @return
     */
    @RequestMapping("/login")
    @JwtIgnore
    public ResponseData login(@RequestBody RequestParam<UserLoginParam> userParam) {
        if(null == userParam.getData()
                || StringUtils.isBlank(userParam.getData().getUserName())
                || StringUtils.isBlank(userParam.getData().getPassword())){
            return ResponseData.failure(BusinessMessageEnum.PARAM_MISS_ERR.getCode(),BusinessMessageEnum.PARAM_MISS_ERR.getMsg());
        }
        return userService.login(userParam.getData());
    }


    @PostMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
