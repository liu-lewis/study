package com.lganlin.springboot.study_02.service;

import com.lganlin.springboot.study_02.inter.ListService;

public class ShowLinux implements ListService {
    @Override
    public String showCommand() {
        return "ls";
    }
}
