package com.maple.dubbo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.maple.dubbo.api.DemoService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author maple 2018.09.11 下午12:25
 */
@Component
public class ConsumerService {

    @Reference(check = false, cluster = "failover", retries = 2,loadbalance = "roundrobin")
    private DemoService demoService;


    public String hello() {

        return demoService.sayHello("maple");
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
    }
}
