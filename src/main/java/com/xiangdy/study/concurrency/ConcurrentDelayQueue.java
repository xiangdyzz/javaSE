package com.xiangdy.study.concurrency;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author xiangDY
 * @Description: 延时队列
 * @date 2019/12/20　11:57
 */
public class ConcurrentDelayQueue {

    static BlockingQueue<Task> blockingQueue = new DelayQueue<Task>();

    static class Task implements Delayed{
        long time ;

        Task(long time){
            this.time = time;
        }
        //设置过期时间
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - System.currentTimeMillis(),TimeUnit.MILLISECONDS) ;
        }
        //设置比较方式
        @Override
        public int compareTo(Delayed o) {
            return this.time - ((Task) o).time<= 0 ? -1 : 1;
        }

        @Override
        public String toString() {
            return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(time)) ;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long time = System.currentTimeMillis();

        for (int i = 1; i < 6; i++) {
             blockingQueue.put(new Task(time +  500 * i));
        }

        System.out.println(blockingQueue);

        for (int i = 0; i < 5; i++) {
            System.out.println(blockingQueue.take());
        }
    }
}
