package com.zcm.springboot.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @ClassName ZCM
 * @Author WXL
 * @Date 2019/8/5 17:31
 * @Description
 */
public class JWTToken implements AuthenticationToken {
    // 密钥
    private String token;

    public JWTToken(String token){
        this.token=token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
