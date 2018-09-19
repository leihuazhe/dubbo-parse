package com.maple.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author maple 2018.09.16 下午4:27
 */
@SPI("zookeeper")
public interface Registry {

    /**
     * register something
     *
     * @param msg input msg
     * @return result string
     */
    @Adaptive()
//    @Adaptive("registry1")
    String register(URL url, String msg);
}


