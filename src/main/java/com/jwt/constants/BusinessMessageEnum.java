package com.jwt.constants;

/**
 * @ClassName:com.jwt.constants.BusinessMessageEnum
 * @Decription：业务消息枚举
 * @Author： huang_guoqiang
 * @Date 2019年05月06日 15:54
 */
public enum BusinessMessageEnum {
    SUCCESS(100,"成功"),
    FAILURE(101,"失败"),
    UNLOGIN(201,"未登录"),
    EXCEPTION(500,"系统异常"),

    COMPLETE_EXCEPTION(001,"计算异常，被除数不能为零！"),

    LOGIN_USERNAME_NOT_EXIST(002,"登录用户名不存在！"),
    LOGIN_PWD_ERR(003,"密码不能为空或错误！"),
    LOGIN_SIGNED_ERR(004,"用户签名失败！"),
    PARAM_MISS_ERR(005,"参数缺失！"),

    DEFAULT_ERR(9999,"网络异常")
    ;

    private Integer code;
    private String msg;

    BusinessMessageEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
