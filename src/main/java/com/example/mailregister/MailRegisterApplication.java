package com.example.mailregister;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@MapperScan("com.example.mailregister.dao")
@EntityScan("com.example.mailregister.entity")
@EnableJpaRepositories("com.example.mailregister.repository")
@SpringBootApplication
public class MailRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailRegisterApplication.class, args);
    }

}
