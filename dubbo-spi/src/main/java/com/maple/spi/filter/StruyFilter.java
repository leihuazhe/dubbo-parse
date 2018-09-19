package com.maple.spi.filter;

import com.alibaba.dubbo.common.URL;

/**
 * @author maple 2018.09.19 下午1:18
 */
public class StruyFilter implements Filter {


    @Override
    public int getPort() {
        return 0;
    }

    @Override
    public String doFilter(URL url, String msg) {
        return "StruyFilter invoke message: " + msg;
    }
}
