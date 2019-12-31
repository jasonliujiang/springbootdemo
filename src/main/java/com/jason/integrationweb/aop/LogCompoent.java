package com.jason.integrationweb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 日志组件，在方法的一前一后打印日志
 */

@Component
//切面注解
@Aspect
public class LogCompoent {
    //任意类。任意方法。方法参数任意<类型，个数>
    @Pointcut("execution(* com.jason.integrationweb.aop.service.*.*(..))")
    public void pcl(){

    }

    /**
     * 定义拦截规则
     *
     * 前置通知
     */
    @Before(value = "pcl()")
    public void before(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println("before---------"+name);
    }


    @After(value = "pcl()")
    public void after(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println("after---------"+name);
    }

    //返回通知
    @AfterReturning(value = "pcl()",returning = "result")
    public void afterRetuning(JoinPoint jp,Object result){
        String name = jp.getSignature().getName();
        System.out.println("afterRetuning---------"+name+">>>>>>>>"+result);
    }

    //异常通知
    @AfterThrowing(value = "pcl()",throwing = "e")
    public void afterThrowing(JoinPoint jp,Exception e){
        String name = jp.getSignature().getName();
        System.out.println("afterThrowing---------"+name+">>>>>>>>"+e.getMessage());

    }

    /**
     * 环绕通知
     * 集大成者，甚至可以篡改返回值（前端值）
     * @param pjp
     * @return
     * @throws Throwable
     */

    @Around("pcl()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object ppp =   pjp.proceed();
        //篡改返回值
        return "篡改返回值";
    }







}
