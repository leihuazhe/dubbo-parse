package com.maple.spi.impl;


import com.alibaba.dubbo.common.URL;
import com.maple.spi.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author maple 2018.09.16 下午4:27
 */
public class ZookeeperRegistry implements Registry {
    private Logger logger = LoggerFactory.getLogger(ZookeeperRegistry.class);

    @Override
    public String register(URL url, String content) {
        logger.info("服务: {} 已注册到zookeeper上，备注: {}", url.getParameter("service"), content);

        return "Zookeeper register already! ";
    }

    @Override
    public String discovery(URL url, String content) {
        logger.info("zookeeper上发现服务: {} , 备注: {}", url.getParameter("service"), content);

        return "Zookeeper discovery already! ";
    }
}
