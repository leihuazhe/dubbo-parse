package com.maple.dubbo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.dubbo.hello.HelloService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author maple 2018.09.11 下午12:25
 */
//@Component
public class ConsumerHelloService {

    @Reference(check = false, cluster = "failover", retries = 2, loadbalance = "roundrobin",version = "1.0.0")
    private HelloService helloService;


    public String hello() {
        return helloService.hello();
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
    }
}
