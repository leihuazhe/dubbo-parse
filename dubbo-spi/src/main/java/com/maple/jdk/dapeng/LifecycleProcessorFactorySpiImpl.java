package com.maple.jdk.dapeng;



/**
 * @author maple 2018.09.26 上午12:18
 */
public class LifecycleProcessorFactorySpiImpl implements LifecycleProcessorFactorySpi {

    @Override
    public LifeCycleProcessor createInstance() {
        return new DefaultLifeCycleProcessor();
    }
}
