package com.lganlin.springboot.study_02.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {

    @PostConstruct
    void init() {
        System.out.println("JSR250 way init");
    }

    public JSR250WayService() {
        System.out.println("JSR250 wat constructor init");
    }

    @PreDestroy
    void destroy() {
        System.out.println("JSR250 way pre destroy");
    }
}
