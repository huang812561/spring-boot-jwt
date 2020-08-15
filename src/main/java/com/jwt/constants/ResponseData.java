package com.jwt.constants;

import java.io.Serializable;

/**
 * @Decription：返回参数
 * @Author： huang_guoqiang
 * @Date 2019年05月10日 9:24
 * @Version 1.0
 */
public class ResponseData implements Serializable {

    protected int code;
    protected int businessCode;
    protected String message;
    protected Object data;


    public ResponseData() {}

    public ResponseData(int code, int businessCode, String message, Object data) {
        this.code = code;
        this.businessCode = businessCode;
        this.message = message;
        this.data = data;
    }

    public static ResponseData success() {
        return success(BusinessMessageEnum.SUCCESS.getCode(), BusinessMessageEnum.SUCCESS.getCode(), "", null);
    }

    public static ResponseData success(Object data) {
        return success(BusinessMessageEnum.SUCCESS.getCode(), BusinessMessageEnum.SUCCESS.getCode(), "", data);
    }

    public static ResponseData success(int businessCode, String message) {
        return success(BusinessMessageEnum.SUCCESS.getCode(), businessCode, message, null);
    }

    public static ResponseData success(int businessCode, String message, Object data) {
        return success(BusinessMessageEnum.SUCCESS.getCode(), businessCode, message, data);
    }

    public static ResponseData success(int code, int businessCode, String message, Object data) {
        return new ResponseData(code, businessCode, message, data);
    }


    public static ResponseData failure() {
        return failure(BusinessMessageEnum.FAILURE.getCode(), BusinessMessageEnum.FAILURE.getCode(), "", "");
    }

    public static ResponseData failure(String message) {
        return failure(BusinessMessageEnum.FAILURE.getCode(), BusinessMessageEnum.FAILURE.getCode(), message, "");
    }

    public static ResponseData failure(Object data) {
        return failure(BusinessMessageEnum.FAILURE.getCode(), BusinessMessageEnum.FAILURE.getCode(), "", data);
    }

    public static ResponseData failure(String message, Object data) {
        return failure(BusinessMessageEnum.FAILURE.getCode(), BusinessMessageEnum.FAILURE.getCode(), message, data);
    }

    public static ResponseData failure(int businessCode, String message) {
        return failure(BusinessMessageEnum.FAILURE.getCode(), businessCode, message, "");
    }

    public static ResponseData failure(int businessCode, String message, Object returnData ) {
        return failure(BusinessMessageEnum.FAILURE.getCode(), businessCode, message, returnData);
    }

    public static ResponseData failure(int code, int businessCode, String message, Object returnData) {
        return new ResponseData(code, businessCode, message, returnData);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(int businessCode) {
        this.businessCode = businessCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
