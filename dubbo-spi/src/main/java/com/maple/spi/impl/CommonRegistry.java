package com.maple.spi.impl;


import com.alibaba.dubbo.common.URL;
import com.maple.spi.Registry;

/**
 * @author maple 2018.09.16 下午4:27
 */
public class CommonRegistry implements Registry {

    private Registry registry;

    public CommonRegistry(Registry registry) {
        this.registry = registry;
    }

    /**
     * register something
     *
     * @param msg input msg
     * @return result string
     */
    @Override
    public String register(URL url, String msg) {
        System.out.println("before ....");
        String register = registry.register(url, msg);
        System.out.println("after ....");
        return register;
    }
}
