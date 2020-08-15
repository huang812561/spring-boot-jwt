package com.jwt.annotation;

import java.lang.annotation.*;

/**
 * @Decription：JWT请求忽略注解
 * @Author： huang_guoqiang
 * @Date 2019年05月05日 10:20
 * @Version 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtIgnore {
}
