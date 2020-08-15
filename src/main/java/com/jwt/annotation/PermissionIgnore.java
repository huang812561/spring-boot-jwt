package com.jwt.annotation;

import java.lang.annotation.*;

/**
 * @Decription：权限忽略
 * @Author： huang_guoqiang
 * @Date 2019年05月15日 13:55
 * @Version 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionIgnore {
}
