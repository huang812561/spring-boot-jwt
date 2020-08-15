package com.jwt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Decription：jwt 相关参数
 * @Author： huang_guoqiang
 * @Date 2019年05月05日 10:08
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtParam {

    /**
     * 发行者名
     */
    private String name;
    /**
     * Base64加密秘钥
     */
    private String base64Secret;
    /**
     * jwt中过期时间设置（分）
     */
    private int jwtExpires;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase64Secret() {
        return base64Secret;
    }

    public void setBase64Secret(String base64Secret) {
        this.base64Secret = base64Secret;
    }

    public int getJwtExpires() {
        return jwtExpires;
    }

    public void setJwtExpires(int jwtExpires) {
        this.jwtExpires = jwtExpires;
    }
}
