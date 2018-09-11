package com.maple.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author maple 2018.09.10 下午11:11
 */
@SpringBootApplication
@EnableDubboConfiguration
public class App {


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
