package com.lganlin.springboot.study_03.controller;

import com.lganlin.springboot.study_03.entity.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan("com.lganlin.springboot.study_03.entity")
public class StudyApplication {

    private static final Logger logger = LoggerFactory.getLogger(StudyApplication.class);

    @Value("${book.name}")
    private String name;

/*    @Value("${book.author}")
    private String author;*/

    @Autowired
    private Author author;


    @RequestMapping("/")
    String index() {
        logger.info("book name: " + name);
        return "hello word!" + author.getName() + author.getAge();
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(StudyApplication.class);
        //app.setBannerMode(Banner.Mode.OFF);
        app.run();
    }
}
