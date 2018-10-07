package com.maple.jdk.spi;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author maple 2018.09.16 下午4:27
 */
public class EtcdRegistry implements Registry {
    private Logger logger = LoggerFactory.getLogger(ZookeeperRegistry.class);

    @Override
    public String register(String content) {
        logger.info("服务: {} 已注册到 Etcd 上", content);
        return "Etcd register already! ";
    }

    @Override
    public String discovery(String content) {
        logger.info("Etcd 上发现服务: {}", content);
        return "Etcd discovery already! ";
    }
}
