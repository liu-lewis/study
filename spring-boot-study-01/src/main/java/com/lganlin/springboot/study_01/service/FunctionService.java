package com.lganlin.springboot.study_01.service;

import org.springframework.stereotype.Service;

@Service
public class FunctionService {

    public String sayHello(String word) {
        return "Hello " + word + " !";
    }
}
