package com.xiangdy.study.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiangDY
 * @Description: TODO
 * @date 2019/12/20　18:37
 */
public class ConcurrentThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = null;
        /**
         * 创建线程需求：在不超过线程固定数目且没有空闲线程可执行情况下，会为任务创建一条新的线程
         * 默认生存周期 60S
         */
     //   Executors.newFixedThreadPool(5);

        /**
         * 缓存线程池，需要一个线程处理，且没有空闲线程能处理我就新建一条线程
         * 创建线程需求，线程池中没有线程空闲的情况下，直接创建，没有数量控制
         * 默认生存周期 60 s,空闲时间超过60s，将被销毁
         */
        // service = Executors.newCachedThreadPool();

        /**
         * 只创建一条线程
         */
       service = Executors.newSingleThreadExecutor();
        /**
         *定时线程池
         */
       // service = Executors.newScheduledThreadPool(5);

        final Integer num = 0;

        int sum = 0;
        for (int i = 0; i < 5; i++) {
//            service.execute(() -> {
//                System.out.println(Thread.currentThread().getName()+"执行线程任务");
//            });

            Future<Integer> future = service.submit(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        int number = num.intValue();
                        AtomicInteger atomic= new AtomicInteger(number);
                        Thread.sleep(1000);
                        atomic.getAndAdd(1);
                        System.out.println(Thread.currentThread().getName()+"==>"+atomic.get());
                        return atomic.get();
                    }
                }
             );

            sum += future.get();
        }

        System.out.println(sum);
    }



}
