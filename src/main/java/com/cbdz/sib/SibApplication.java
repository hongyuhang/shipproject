package com.cbdz.sib;

import com.cbdz.sib.common.Constant;
import com.cbdz.sib.controller.schedule.SaveMmsiHistorySchedule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.cbdz.sib.dao")
@EnableScheduling
public class SibApplication {
    public static void main(String[] args) {
        SpringApplication.run(SibApplication.class, args);
    }
}
