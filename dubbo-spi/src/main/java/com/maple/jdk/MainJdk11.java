package com.maple.jdk;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author maple 2018.09.26 上午10:35
 */
public class MainJdk11 {

    @Resource
    private String msg;

    public static void main(String[] args) {
        var x = 12;

        System.out.println(x);

//        immutable
        List<Integer> inters = List.of(1, 2);

        inters.forEach(System.out::println);

        ProcessHandle current = ProcessHandle.current();
        Stream<ProcessHandle> children = current.children();

        System.out.println(children);


    }
}
