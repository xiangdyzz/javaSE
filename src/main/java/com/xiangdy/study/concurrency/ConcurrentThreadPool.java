package com.xiangdy.study.concurrency;

import java.util.concurrent.Executors;

/**
 * @author xiangDY
 * @Description: TODO
 * @date 2019/12/20　18:37
 */
public class ConcurrentThreadPool {

    public static void main(String[] args) {
        Executors.newFixedThreadPool(5);

//        Executors.newCachedThreadPool();
//
//        Executors.newSingleThreadExecutor();
//
//        Executors.newScheduledThreadPool(5);
    }



}
