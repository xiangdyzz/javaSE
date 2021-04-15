package com.xiangdy.study.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * steam API
 */
public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");

        //将两个字符串拆分再合并
        list.stream().flatMap(item ->  Arrays.stream(item.split(",")))
                .forEach(System.out::println);
    }
}
