package com.gupao.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.net.UnknownHostException;

@SpringBootApplication
@ComponentScan(value = {"com.gupao"})
@MapperScan("com.gupao.springbootdemo.user.dao")
public class SpringbootDemoApplication {

    public static void main(String[] args) throws UnknownHostException {

        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
