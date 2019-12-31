package com.jason.integrationweb.json.bean;

import java.util.Date;

public class UserJson {
    private Integer id;
    private String userName;
    private String address;
    //添加注解定义时间格式
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
