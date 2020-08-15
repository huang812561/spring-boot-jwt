package com.jwt.exception;

import com.jwt.constants.BusinessMessageEnum;
import com.jwt.constants.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @Decription：全局异常处理
 * @Author： huang_guoqiang
 * @Date 2019年05月05日 16:17
 * @Version 1.0
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    //运行时异常
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseData runtimeExceptionHandler(RuntimeException e){
        log.error("全局异常-RuntimeException：{}",e);
        return ResponseData.failure(e.getMessage());
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public ResponseData nullPointerExceptionHandler(NullPointerException ex) {
        log.error("全局异常-NullPointerException:{}",ex);
        return ResponseData.failure(ex.getMessage());
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public ResponseData classCastExceptionHandler(ClassCastException ex) {
        log.error("全局异常-ClassCastException:{}",ex);
        return ResponseData.failure(500, ex.getMessage());
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public ResponseData iOExceptionHandler(IOException ex) {
        log.error("全局异常-IOException:{}",ex);
        return ResponseData.failure(500, ex.getMessage());
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public ResponseData noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        log.error("全局异常-NoSuchMethodException:{}",ex);
        return ResponseData.failure(500, ex.getMessage());
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseData indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        log.error("全局异常-IndexOutOfBoundsException:{}",ex);
        return ResponseData.failure(500, ex.getMessage());
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseData requestNotReadable(HttpMessageNotReadableException ex) {
        log.error("全局异常-HttpMessageNotReadableException:{}",ex);
        return ResponseData.failure(400, ex.getMessage());
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public ResponseData requestTypeMismatch(TypeMismatchException ex) {
        log.error("全局异常-TypeMismatchException:{}",ex);
        return ResponseData.failure(400, ex.getMessage());
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResponseData requestMissingServletRequest(MissingServletRequestParameterException ex) {
        log.error("全局异常-MissingServletRequest:{}",ex);
        return ResponseData.failure(400, ex.getMessage());
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseData request405(HttpRequestMethodNotSupportedException ex) {
        log.error("全局异常-HttpRequestMethodNotSupportedException:{}",ex);
        return ResponseData.failure(405, ex.getMessage());
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public ResponseData request406(HttpMediaTypeNotAcceptableException ex) {
        log.error("全局异常-HttpMediaTypeNotAcceptableException:{}",ex);
        return ResponseData.failure(406, ex.getMessage());
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public ResponseData server500(RuntimeException ex) {
        log.error("全局异常-HttpMessageNotWritableException:{}",ex);
        return ResponseData.failure(500, ex.getMessage());
    }

    //栈溢出
    @ExceptionHandler({StackOverflowError.class})
    public ResponseData requestStackOverflow(StackOverflowError ex) {
        log.error("全局异常-StackOverflowError:{}",ex);
        return ResponseData.failure(500, ex.getMessage());
    }

    //默认异常（其它）
    @ExceptionHandler(value = Exception.class)
    public ResponseData defaultException(Exception e){
        log.error("全局异常-Exception：{}",e);
        return ResponseData.failure(e.getMessage());
    }

    //自定义异常
    @ExceptionHandler(value = MyException.class)
    public ResponseData myException(MyException e){
        log.error("全局异常-MyException：{}",e);
        Integer code=e.getCode();
        String message=e.getMessage();
        if (e.getCode()==null){
            code=BusinessMessageEnum.FAILURE.getCode();
        }
        if (e.getMessage()==null){
            message=BusinessMessageEnum.FAILURE.getMsg();
        }
        return ResponseData.failure(code,message);
    }

}
