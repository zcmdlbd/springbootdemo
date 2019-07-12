package com.zcm.springboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ZCM
 * @Author WXL
 * @Date 2019/7/11 15:31
 * @Description 全局异常捕获
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    //错误显示页面
    public static final  String viewName="common/error";
    
    /**
     * @author zcm
     * @date 2019/7/11 15:33
     * 判断是否是ajax请求
     * @Param
     * @return 
     * @throws
    */
    public static boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals(httpRequest.getHeader("X-Requested-With").toString()));
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingServletRequestParameterException(MissingServletRequestParameterException e, Model model) {
        log.error("缺少请求参数", e);
        String message = "【缺少请求参数】" + e.getMessage();
        model.addAttribute("message", message);
        model.addAttribute("code", 400);
        return viewName;
    }

    /**
     * 404 - Not Found
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public String noHandlerFoundException(NoHandlerFoundException e, Model model) {
        log.error("Not Found", e);
        String message = "【页面不存在】" + e.getMessage();
        model.addAttribute("message", message);
        model.addAttribute("code", 404);
        return viewName;
    }


    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, Model model) {
        log.error("不支持当前请求方法", e);
        String message = "【不支持当前请求方法】" + e.getMessage();
        model.addAttribute("message", message);
        model.addAttribute("code", 405);
        return viewName;
    }

}
