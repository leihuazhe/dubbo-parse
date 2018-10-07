package com.maple.spi.impl;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.maple.spi.Registry;

/**
 * @author maple 2018.09.20 下午11:33
 */
public class Main {

    public static void main(String[] args) {
        URL url = URL.valueOf("test://localhost/test").addParameter("service", "helloService")
                /*.addParameter("registry","etcd")*/;

        Registry registry = ExtensionLoader.getExtensionLoader(Registry.class).getAdaptiveExtension();

        String register = registry.register(url, "maple");

        System.out.println(register);

        System.out.println(ExtensionLoader.getExtensionLoader(Registry.class).getSupportedExtensions().toString());

    }
}
