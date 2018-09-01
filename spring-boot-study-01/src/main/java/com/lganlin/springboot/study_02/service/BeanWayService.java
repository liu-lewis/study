package com.lganlin.springboot.study_02.service;

public class BeanWayService {

    void init() {
        System.out.println("bean way init!");
    }

    public BeanWayService() {
        System.out.println("bean way constructor init");
    }

    void destroy() {
        System.out.println("bean way pre destroy");
    }
}
