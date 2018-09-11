package com.maple.api;

import java.io.Serializable;

/**
 * @author maple 2018.09.10 下午11:04
 */
public class City implements Serializable {

    private String name;

    private String from;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public City(String name, String from) {
        this.name = name;
        this.from = from;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
