package com.maple.jdk.spi;

public interface Registry {

    /**
     * register something
     */
    String register(String msg);


    String discovery(String content);
}

