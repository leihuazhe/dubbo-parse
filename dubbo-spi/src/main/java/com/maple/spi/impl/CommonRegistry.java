package com.maple.spi.impl;


import com.alibaba.dubbo.common.URL;
import com.maple.spi.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author maple 2018.09.16 下午4:27
 */
public class CommonRegistry implements Registry {
    private Logger logger = LoggerFactory.getLogger(CommonRegistry.class);

    private Registry registry;

    public CommonRegistry(Registry registry) {
        this.registry = registry;
    }

    @Override
    public String register(URL url, String msg) {
        long begin = System.currentTimeMillis();
        String register = registry.register(url, msg);
        long end = System.currentTimeMillis();
        logger.info("register method 处理耗时 cost: {} ms", end - begin);
        return register;
    }


    @Override
    public String discovery(URL url, String content) {
        return null;
    }
}
