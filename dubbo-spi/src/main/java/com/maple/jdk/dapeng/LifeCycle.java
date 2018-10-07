package com.maple.jdk.dapeng;

/**
 * @author maple 2018.09.26 上午12:06
 */
public interface LifeCycle {
    /**
     * 容器启动时回调方法
     */
    void start();

    /**
     * 容器停止
     */
    void stop();
}

