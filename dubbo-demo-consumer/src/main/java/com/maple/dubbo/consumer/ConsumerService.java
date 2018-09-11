package com.maple.dubbo.consumer;

import com.maple.dubbo.api.DemoService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author maple 2018.09.11 下午12:25
 */
@ComponentScan
public class ConsumerService {
    @Reference
    private DemoService demoService;


    public void hello() {
        demoService.sayHello("maple");
    }
}
