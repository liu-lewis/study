package com.lganlin.springboot.study_02.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsynTaskService {

    @Async
    public void executeAsyncTask(Integer i) {
        System.out.println(Thread.currentThread().getName() + " multitask execute: " + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println(Thread.currentThread().getName() + " execute async task +1 : " + (i+1));
    }
}
