package com.lganlin.springboot.study_02.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduleService {

    public static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    void reportCurrentTime() {
        System.out.println("5 times per seconds" + sdf.format(new Date()));
    }

    @Scheduled(cron = "0 29 17 ? * *")
    void specifiedTimeExecute() {
        System.out.println(sdf.format(new Date()) + " execute");
    }
}
