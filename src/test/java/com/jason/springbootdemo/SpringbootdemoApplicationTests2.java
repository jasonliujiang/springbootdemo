package com.jason.springbootdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jason.devtools.test.TestBook;
import com.jason.persistent.redis.service.redisservice;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 使用resttemplate进行单元测试（json测试）
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringbootdemoApplicationTests2 {

    @Autowired
    TestRestTemplate testRestTemplate;


    //controller测试
    @Test
    public void contextLoads() {
        String jason = testRestTemplate.getForObject("/test?name={1}", String.class, "jason");
        System.out.println(jason);

    }

    @Test
    public void testJson(){
        TestBook testBook = new TestBook();
        testBook.setId(99);
        testBook.setAuthor("刘慈欣");
        testBook.setName("三体");

        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        JSONObject jsonObject = (JSONObject) JSON.toJSON(testBook);


        //JSONObject jsonObj = JSON.parseObject(testBook.toString());

        HttpEntity<Object> formEntity = new HttpEntity<Object>(jsonObject, headers);

        //String result = restTemplate.postForObject(url, formEntity, String.class);



        ResponseEntity<Object> responseEntity = testRestTemplate.postForEntity("/test/addBook", formEntity,Object.class);
        System.out.println(responseEntity);
    }







}
