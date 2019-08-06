package com.zcm.springboot.exception;

/**
 * @ClassName ZCM
 * @Author WXL
 * @Date 2019/8/5 17:27
 * @Description
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}
