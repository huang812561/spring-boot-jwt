package com.jwt.constants;

import lombok.Data;

/**
 * @Decription：请求参数
 * @Author： huang_guoqiang
 * @Date 2019年05月13日 13:41
 * @Version 1.0
 */
@Data
public class RequestParam<T> {

    private String token;
    private T data;

}
