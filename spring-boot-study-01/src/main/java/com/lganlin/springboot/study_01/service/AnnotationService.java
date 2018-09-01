package com.lganlin.springboot.study_01.service;

import com.lganlin.springboot.study_01.annotation.Action;
import org.springframework.stereotype.Service;

@Service
public class AnnotationService {

    @Action(name = "zhu jie shi lan jie add !")
    public void add() {
        System.out.println("annotation service");
    }
}
