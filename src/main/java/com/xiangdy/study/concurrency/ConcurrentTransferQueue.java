package com.xiangdy.study.concurrency;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author xiangDY
 * @Description: 转移队列
 * @date 2019/12/20　14:22
 */
public class ConcurrentTransferQueue {

    static TransferQueue<String> transferQueue = new LinkedTransferQueue();

    public static void main(String[] args) throws Exception {
        //消费者必须先于生产者启动
        new Thread(() -> {
            try {
                while (true){
                    System.out.println(transferQueue.take());
                    if(transferQueue.size() == 0) break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //调用转移函数,直接将队列中的数据转交给消费者，假如没有消费者，则进入阻塞状态
        transferQueue.transfer("1");
    }
}
