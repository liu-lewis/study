package com.lganlin.springboot.study_02.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
@ComponentScan("com.lganlin.springboot.study_02")
@PropertySource("classpath:application.yml")
public class ElConfig {

    @Value("love you ")
    private String normal;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{T(java.lang.Math).random() * 100.0}")
    private double random;

    @Value("#{configService.other}")
    private String fromService;

    @Value("classpath:conf.txt")
    private Resource file;

    @Value("${spring.redis.host}")
    private String host;

    @Value("http://www.baidu.com")
    private Resource url;

    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void print() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(random);
            System.out.println(fromService);
            System.out.println(IOUtils.toString(file.getInputStream()));
            System.out.println(IOUtils.toString(url.getInputStream()));
            System.out.println(host);
            System.out.println(environment.getProperty("spring.redis.host"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
