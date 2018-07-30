package com.lganlin.springboot.study_01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.lganlin.springboot")
@EnableAspectJAutoProxy
public class AopConfig {
}
