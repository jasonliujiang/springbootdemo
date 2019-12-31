package com.jason.springbootdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jason.devtools.test.TestBook;
import com.jason.persistent.mybatis.bean.User;
import com.jason.persistent.mybatis.mapper.UserMapper;
import com.jason.persistent.mybatis2.mapper1.UserMapper1;
import com.jason.persistent.mybatis2.mapper2.UserMapper2;
import com.jason.persistent.redis.service.redisservice;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @Autowired
    redisservice redisservice;

    //测试
    @Test
    public void contextLoads() {
        //测试service
        String s = redisservice.hello();
        Assert.assertThat(s, Matchers.is("v1"));





    }

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testController() throws Exception {

            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/test/hello")
                            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                            .param("name", "jason"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void testControllerJson() throws Exception {
        TestBook testBook = new TestBook();
        testBook.setId(99);
        testBook.setAuthor("刘慈欣");
        testBook.setName("三体");

        String s = new ObjectMapper().writeValueAsString(testBook);

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/test/addBook")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(s))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

    }


}
