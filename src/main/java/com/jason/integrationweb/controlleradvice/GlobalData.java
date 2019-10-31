package com.jason.integrationweb.controlleradvice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 *ControllerAdvice预设全局数据
 * 任何一个controller都可以获取到预设的全局数据
 * @author liujiang02
 */

@ControllerAdvice
public class GlobalData {
    @ModelAttribute(value = "info")
    public Map<String,Object> mudata(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","jason");
        map.put("adress","www.jaspon.cn");
        return map;
    }


    /**
     * 对请求参数预处理，对变量中有相同参数进行绑定
     * @param binder
     */
    @InitBinder("a")
    public void initA(WebDataBinder binder){
        binder.setFieldDefaultPrefix("a.");
    }

    @InitBinder("b")
    public void initB(WebDataBinder binder){
        binder.setFieldDefaultPrefix("b.");
    }
}
