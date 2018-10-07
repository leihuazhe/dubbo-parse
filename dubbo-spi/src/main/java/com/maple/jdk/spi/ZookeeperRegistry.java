package com.maple.jdk.spi;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author maple 2018.09.16 下午4:27
 */
public class ZookeeperRegistry implements Registry {
    private Logger logger = LoggerFactory.getLogger(ZookeeperRegistry.class);

    @Override
    public String register(String content) {
        logger.info("服务: {} 已注册到zookeeper上 ", content);

        return "Zookeeper register already! ";
    }

    @Override
    public String discovery(String content) {
        logger.info("zookeeper上发现服务: {} ", content);

        return "Zookeeper discovery already! ";
    }
}
