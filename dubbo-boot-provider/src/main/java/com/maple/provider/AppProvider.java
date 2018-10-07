package com.maple.provider;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author maple 2018.09.10 下午11:11
 */
@SpringBootApplication
@DubboComponentScan
public class AppProvider {


    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(AppProvider.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

}
