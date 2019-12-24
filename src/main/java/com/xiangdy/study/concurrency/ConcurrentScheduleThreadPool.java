package com.xiangdy.study.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author xiangDY
 * @Description: 定时线程池
 * @date 2019/12/23　11:09
 */
public class ConcurrentScheduleThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },0,500, TimeUnit.MICROSECONDS);



    }


}
