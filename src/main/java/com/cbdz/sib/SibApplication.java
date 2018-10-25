package com.cbdz.sib;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cbdz.sib.dao")
public class SibApplication {
    public static void main(String[] args) {
        SpringApplication.run(SibApplication.class, args);
    }
}
