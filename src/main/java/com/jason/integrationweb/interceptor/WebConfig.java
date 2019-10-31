package com.jason.integrationweb.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 添加拦截器配置
 *
 * @author liujiang02
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myinterceptor()).addPathPatterns("/**");
    }

    @Bean
    Myinterceptor myinterceptor(){
        return new Myinterceptor();
    }
}
