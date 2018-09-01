package com.lganlin.springboot.study_01.service;

import org.springframework.stereotype.Service;

@Service
public class MethodService {
    public void add() {
        System.out.println("service aspect");
    }
}
