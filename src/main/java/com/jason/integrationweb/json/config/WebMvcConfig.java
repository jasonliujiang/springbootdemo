package com.jason.integrationweb.json.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.SimpleDateFormat;


/**
 * 重写HttpMessageConverter，自定义全局json的时间格式，编码格式等。
 */
@Configuration
public class WebMvcConfig {
    @Bean
    MappingJackson2HttpMessageConverter mappingJackson2CborHttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy/MM/dd"));
        converter.setObjectMapper(mapper);
        return converter;
    }


//    /**
//     * 默认json时间格式生成
//     * @return
//     */
//    @Bean
//    ObjectMapper objectMapper(){
//        ObjectMapper  om = new ObjectMapper();
//        om.setDateFormat(new SimpleDateFormat("yyyy/MM/dd"));
//        return om;
//    }

//    /**
//     *
//     * gson日期配置
//     * @return
//     */
//    @Bean
//    GsonHttpMessageConverter gsonHttpMessageConverter(){
//        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
//        converter.setGson(new GsonBuilder().setDateFormat("yyyy/MM/dd").create());
//        return converter;
//    }
//    @Bean
//    GsonBuilder gson(){
//        return (new GsonBuilder().setDateFormat("yyyy/MM/dd"));
//    }


//    @Bean
//    FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
//        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//        FastJsonConfig config = new FastJsonConfig();
//        config.setDateFormat("yyyy+MM+dd");
//        //config.setCharset(UTF_32);
//        converter.setFastJsonConfig(config);
//        return converter;
//    }


}
