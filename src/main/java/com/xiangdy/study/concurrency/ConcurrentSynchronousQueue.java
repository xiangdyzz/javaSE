package com.xiangdy.study.concurrency;

import java.util.concurrent.SynchronousQueue;

/**
 * @author xiangDY
 * @Description: 同步队列，实际上就是特殊的传输队列
 * 和transferQueue的区别在于transferQueue可以有其他堵塞的容器
 * @date 2019/12/20　14:33
 */
public class ConcurrentSynchronousQueue {

    public static void main(String[] args) throws InterruptedException {

        SynchronousQueue<String> synchronousQueue = new SynchronousQueue();//容量为0

        new Thread(() -> {
            try {
                System.out.println(synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        synchronousQueue.put("1");//阻塞等待消费者消费
    }
}
