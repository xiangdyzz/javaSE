package com.xiangdy.study.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiangDY
 * @Description: 线程池相关api调用
 * @date 2019/12/20　16:07
 */
public class ConcurrentExecutor {

    public static void main(String[] args) {
        //创建size=5的线程池
        ExecutorService service =  Executors.newFixedThreadPool(5);

        //循环打印线程池中的线程名称
        for (int i = 0; i < 6; i++) {
            service.execute(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        System.out.println(service);

        service.shutdown();//在所有线程执行结束之后，关闭线程池
        System.out.println(service.isShutdown());//线程池是否正在关闭
        System.out.println(service.isTerminated());//所有线程执行的任务是否已经终结
        System.out.println(service);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(service);
        System.out.println(service.isShutdown());
        System.out.println(service.isTerminated());
    }
}
