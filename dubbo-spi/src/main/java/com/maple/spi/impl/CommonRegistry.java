//package com.maple.spi.impl;
//
//
//import com.alibaba.dubbo.common.URL;
//import com.maple.spi.Registry;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * @author maple 2018.09.16 下午4:27
// */
//public class CommonRegistry implements Registry {
//    private Logger logger = LoggerFactory.getLogger(CommonRegistry.class);
//
//    private Registry registry;
//
//    public CommonRegistry(Registry registry) {
//        this.registry = registry;
//    }
//
//    /**
//     * register something
//     *
//     * @param msg input msg
//     * @return result string
//     */
//    @Override
//    public String register(URL url, String msg) {
//        long begin = System.currentTimeMillis();
//        logger.info("CommonRegistry before ....");
//        String register = registry.register(url, msg);
//        long end = System.currentTimeMillis();
//        logger.info("CommonRegistry after .... cost: {} ms", end - begin);
//        return register;
//    }
//}
