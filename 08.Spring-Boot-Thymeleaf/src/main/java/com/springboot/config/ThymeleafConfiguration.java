package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * 这个类能干啥，不加也能找到项目根路径那
 */
@Component
public class ThymeleafConfiguration {
    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;

    @PostConstruct
    public void init(){
        HashMap hashMap = new HashMap();
        hashMap.put("contextPath","web");
        thymeleafViewResolver.setStaticVariables(hashMap);
    }
}
