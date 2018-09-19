package com.maple.spi.impl;


import com.alibaba.dubbo.common.URL;
import com.maple.spi.Registry;

/**
 * @author maple 2018.09.16 下午4:27
 */
//@Activate(group = {"group1", "group2"})
public class ConsulRegistry implements Registry {

    /**
     * register something
     *
     * @param msg input msg
     * @return result string
     */
    @Override
    public String register(URL url, String msg) {

        return "ConsulRegistry register already! ";
    }
}
