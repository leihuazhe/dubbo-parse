package com.maple.jdk.dapeng;


import java.util.ServiceLoader;

/**
 * @author maple 2018.09.26 上午12:18
 */
public class ProcessorFactory {

    private static volatile LifeCycleProcessor lifecycleProcessor;

    public static void createLifecycleProcessor(ClassLoader containerCl) {
        if (lifecycleProcessor == null) {
            synchronized (ProcessorFactory.class) {
                ServiceLoader<LifecycleProcessorFactorySpi> lifecycleProcessorFactorySpis = ServiceLoader.load(LifecycleProcessorFactorySpi.class, containerCl);
                assert lifecycleProcessorFactorySpis.iterator().hasNext();
                lifecycleProcessor = lifecycleProcessorFactorySpis.iterator().next().createInstance();
            }
        }
    }

    public static LifeCycleProcessor getLifecycleProcessor() {
        return lifecycleProcessor;
    }
}
