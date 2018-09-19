package com.maple.spi.filter;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author maple 2018.09.19 下午1:18
 */
@SPI
public interface Filter {

    int getPort();

    @Adaptive
    String doFilter(URL url, String msg);


}
