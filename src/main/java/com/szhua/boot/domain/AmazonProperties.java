package com.szhua.boot.domain;
/*
*@author szhua 2018/1/3/003
*AmazonProperties
github@szhua
*/

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


//在一个类里收集属性
@Component
/*注入带amazon
前缀的属性*/
@ConfigurationProperties("amazon")
public class AmazonProperties {
    private String associateId ;
    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }
    public String getAssociateId() {
        return associateId;
    }
}
