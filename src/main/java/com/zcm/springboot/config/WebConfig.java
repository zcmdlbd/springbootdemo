package com.zcm.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName ZCM
 * @Author WXL
 * @Date 2019/7/11 15:26
 * @Description 支持跨域，别问，问就度娘
 */
public class WebConfig implements WebMvcConfigurer {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");    //允许任何域名
        corsConfiguration.setAllowCredentials(true); //
        corsConfiguration.addAllowedHeader("*");    //允许任何头
        corsConfiguration.addAllowedMethod("*");       //允许任何方法

        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());  //注册
        return new CorsFilter(source);
    }
}
