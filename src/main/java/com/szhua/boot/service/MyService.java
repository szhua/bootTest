package com.szhua.boot.service;
/*
*@author szhua 2018/1/2/002
*MyService
github@szhua
*/


import com.szhua.boot.JdbcTemplateCondition;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Conditional;

public class MyService {

    @Conditional(JdbcTemplateCondition.class)
    public MyService myService() {
    return  null ;
    }
}
