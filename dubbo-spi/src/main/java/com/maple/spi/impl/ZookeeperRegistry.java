package com.maple.spi.impl;


import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Activate;
import com.maple.spi.Registry;

/**
 * @author maple 2018.09.16 下午4:27
 */
//@Activate(group = {"default_group"})
public class ZookeeperRegistry implements Registry {

    /**
     * register something
     *
     * @param msg input msg
     * @return result string
     */
    @Override
    public String register(URL url, String msg) {
        System.out.println("access in zookeepr");

        return "Zookeeper register already! ";
    }
}
