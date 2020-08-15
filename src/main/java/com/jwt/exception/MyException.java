package com.jwt.exception;

import lombok.Data;

/**
 * @Decription：自定义异常
 * @Author： huang_guoqiang
 * @Date 2019年05月05日 16:05
 * @Version 1.0
 */
@Data
public class MyException extends Exception {


    /**
     * 错误编码
     */
    private Integer code;

    public MyException(String message) {
        super(message);
    }

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
