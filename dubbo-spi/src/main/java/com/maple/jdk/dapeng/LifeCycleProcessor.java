package com.maple.jdk.dapeng;

/**
 * @author maple 2018.09.26 上午12:09
 */
public interface LifeCycleProcessor {
    void onLifecycleEvent();

    void addLifecycles(LifeCycle lifeCycles);


    void removeLifecycles(LifeCycle lifeCycles);
}
