package com.xiangdy.study.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author xiangDY
 * @Description: 计算100万长度的数组内的值的总和
 * @date 2019/12/24　16:50
 */
public class ConcurrentForkJoin {

    static int[] numbers = new int[1000000];
    static final int MAX_RATIO = 50000;

    static {
        Random r = new Random();
        for (int i = 0; i < numbers.length ; i++) {
            numbers[i] = r.nextInt(100);
        }

        System.out.println(Arrays.stream(numbers).sum());
    }

    public static void main(String[] args) {
       ComputingTask computingTask = new ComputingTask(0,numbers.length);
       new ForkJoinPool().execute(computingTask);


       System.out.println(computingTask.join());

    }

    static class ComputingTask extends RecursiveTask<Long> {
        int start;
        int end;


        public ComputingTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        //分支计算
        @Override
        protected Long compute() {
            if(end - start <= MAX_RATIO){
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += numbers[i];
                }
                return sum;
            }else{
               int middle = start + (end - start) /2 ;
               ComputingTask computingTask1 = new ComputingTask(start,middle);
               ComputingTask computingTask2 = new ComputingTask(middle,end);
               computingTask1.fork();
               computingTask2.fork();

               return computingTask1.join()+computingTask2.join();
            }
        }
    }





}
