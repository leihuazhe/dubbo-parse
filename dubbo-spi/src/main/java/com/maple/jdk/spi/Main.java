package com.maple.jdk.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author maple 2018.09.26 上午12:30
 */
public class Main {

    public static void main(String[] args) {
        ServiceLoader<Registry> load = ServiceLoader.load(Registry.class);

        Iterator<Registry> iterator = load.iterator();

        while (iterator.hasNext()) {
            Registry next = iterator.next();
            String helllo = next.register("hello");
            System.out.println(helllo);
        }
    }
}
