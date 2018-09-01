package com.lganlin.springboot.study_02.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.lganlin.springboot.study_02.service")
@EnableScheduling
public class ScheduleConfig {
}
