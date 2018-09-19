package com.maple.spi.rpc;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * @author maple 2018.09.19 上午11:16
 */
public class DubboRpcTest {
    private static Logger logger = LoggerFactory.getLogger(DubboRpcTest.class);

//    private static Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();

    public static void main(String[] args) {
        Set<String> supportedExtensions = ExtensionLoader.getExtensionLoader(Protocol.class).getSupportedExtensions();

        supportedExtensions.forEach(System.out::println);

        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();

        int defaultPort = protocol.getDefaultPort();
        logger.info("defaultPort: {}", defaultPort);

    }
}
