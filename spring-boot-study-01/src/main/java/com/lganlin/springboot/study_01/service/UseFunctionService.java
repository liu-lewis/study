package com.lganlin.springboot.study_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {

    @Autowired
    FunctionService fucntionService;

     public String sayHello(String word) {
         return fucntionService.sayHello(word);
     }
}
