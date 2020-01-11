package com.xiangdy.study.concurrency;

import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiangDY
 * @Description: ArrayList线程不安全，请写一个例子
 * @date 2019/12/25　10:58
 */
public class ArrayListTest {


    public static void main(String[] args) {
         List<Integer> elements = new CopyOnWriteArrayList<>();


        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                elements.add(new Random().nextInt(100));
                System.out.println(Thread.currentThread().getName()+"==>"+elements);
            }).start();
        }
    }



}
