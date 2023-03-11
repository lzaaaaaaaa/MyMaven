package com.high;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.high.dao")
@ServletComponentScan({"com.high.listener", "com.high.filter"})//监听器，过滤器的扫包
public class WinterVacationProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WinterVacationProjectApplication.class, args);
    }

}
