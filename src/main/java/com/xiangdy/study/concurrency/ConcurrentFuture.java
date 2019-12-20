package com.xiangdy.study.concurrency;

import java.util.concurrent.*;

/**
 * @author xiangDY
 * @Description: 并发类 Future
 * 接受未来的执行结果
 * @date 2019/12/20　16:44
 */
public class ConcurrentFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //定义任务
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                return 1000;
            }
        });
        //执行任务
        new Thread(futureTask).start();
        //获取任务结果
        //System.out.println(futureTask.get());

        //使用线程池技术
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1000;
            }
        });

        System.out.println(future.get()); //获得任务执行的结果  &  线程是堵塞的
        System.out.println(future.isDone()); //任务是否执行完毕
        System.out.println(executorService);

    }

}
