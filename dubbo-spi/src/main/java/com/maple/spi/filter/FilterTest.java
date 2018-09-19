package com.maple.spi.filter;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * @author maple 2018.09.19 下午1:21
 */
public class FilterTest {
    private static Logger logger = LoggerFactory.getLogger(FilterTest.class);

    public static void main(String[] args) {
        Set<String> supportedExtensions = ExtensionLoader.getExtensionLoader(Filter.class).getSupportedExtensions();

        supportedExtensions.forEach(System.out::println);

        Filter filter = ExtensionLoader.getExtensionLoader(Filter.class).getAdaptiveExtension();

        String result = filter.doFilter(URL.valueOf("test").addParameter("filter","struy"), "hello world");

        logger.info("filter.doFilter: {}", result);

//        int defaultPort = filter.getPort();
//        logger.info("defaultPort: {}", defaultPort);


    }
}
