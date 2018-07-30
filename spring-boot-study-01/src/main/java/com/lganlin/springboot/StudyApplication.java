package com.lganlin.springboot;

import com.lganlin.springboot.study_01.config.AopConfig;
import com.lganlin.springboot.study_01.config.FConfig;
import com.lganlin.springboot.study_01.service.AnnotationService;
import com.lganlin.springboot.study_01.service.MethodService;
import com.lganlin.springboot.study_01.service.UseFunctionService;
import com.lganlin.springboot.study_02.config.*;
import com.lganlin.springboot.study_02.event.PublishEvent;
import com.lganlin.springboot.study_02.inter.ListService;
import com.lganlin.springboot.study_02.service.BeanWayService;
import com.lganlin.springboot.study_02.service.ConfigService;
import com.lganlin.springboot.study_02.service.JSR250WayService;
import com.lganlin.springboot.study_02.thread.AsynTaskService;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class StudyApplication {

    /*public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("fk"));
        context.close();
    }*/

    @Test
    public void aspectTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        AnnotationService annotationService = context.getBean(AnnotationService.class);
        MethodService methodService = context.getBean(MethodService.class);
        annotationService.add();
        methodService.add();
        context.close();
    }

    @Test
    public void timeUnitTest() {
        TimeUnit t = TimeUnit.HOURS;
        long time = 10;
        System.out.println(t.toSeconds(10));
        try{
            System.out.println("fkkkk");
            int i = 1/0;
        } finally {
            System.out.println("supervise");
        }

    }

    @Test
    public void run_02() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name") + ": " + listService.showCommand());
    }

    @Test
    public void run_03() {
        SpringApplication.run(StudyApplication.class);
    }
}
