package com.example.mailregister;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@MapperScan("com.example.mailregister.dao")
@SpringBootApplication
public class MailRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailRegisterApplication.class, args);
    }

}
