package com.jason.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.Password;

/**
 *Security配置
 */
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    // 密码不加密
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //super.configure(auth);
//        auth.inMemoryAuthentication()
//                .withUser("jason").password("123").roles("admin")
//                .and()
//                .withUser("liujiang").password("123456").roles("user");
//    }

    /**
     * httpSecurity配置
     * @param http
     * @throws Exception
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin/**").hasRole("admin")
//                .antMatchers("user/**").hasAnyRole("admin","user")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/doLogin")
//                //.loginPage("login")
//                .permitAll()
//                .and()
//                .csrf().disable();//注意关掉csrf攻击
//    }
}
