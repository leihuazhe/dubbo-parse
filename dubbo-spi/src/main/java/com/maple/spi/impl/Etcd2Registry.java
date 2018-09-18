package com.maple.spi.impl;


import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.maple.spi.Registry;

/**
 * @author maple 2018.09.16 下午4:27
 */
//@Activate(order = 1, group = {"etcd"})
public class Etcd2Registry implements Registry {

    /**
     * register something
     *
     * @param msg input msg
     * @return result string
     */
    @Override
    public String register(URL url, String msg) {

        return "Etcd2Registry register already! ";
    }
}
