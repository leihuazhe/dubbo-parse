package com.maple.dubbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maple 2018.09.10 下午11:21
 */
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;


    @RequestMapping("/hello")
    public Object hello() {
        return helloService.hello();
    }
}
