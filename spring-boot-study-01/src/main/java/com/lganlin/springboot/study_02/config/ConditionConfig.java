package com.lganlin.springboot.study_02.config;

import com.lganlin.springboot.study_02.condition.ConditionLinux;
import com.lganlin.springboot.study_02.condition.ConditionWin;
import com.lganlin.springboot.study_02.inter.ListService;
import com.lganlin.springboot.study_02.service.ShowLinux;
import com.lganlin.springboot.study_02.service.ShowWin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(ConditionWin.class)
    public ListService winService() {
        return new ShowWin();
    }

    @Bean
    @Conditional(ConditionLinux.class)
    public ListService linuxService() {
        return new ShowLinux();
    }
}
