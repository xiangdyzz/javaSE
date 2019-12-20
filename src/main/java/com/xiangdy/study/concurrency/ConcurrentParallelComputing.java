package com.xiangdy.study.concurrency;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xiangDY
 * @Description: 并行计算
 * @date 2019/12/20　17:26
 */
public class ConcurrentParallelComputing {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long  start = System.currentTimeMillis();
        List<Integer> list = getPrimes(1,200000);
        long  end   = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(4);
        ComputingPrime task1 = new ComputingPrime(1,80000);
        ComputingPrime task2 = new ComputingPrime(80001,130000);
        ComputingPrime task3 = new ComputingPrime(130001,170000);
        ComputingPrime task4 = new ComputingPrime(170001,200000);

        Future<List<Integer>> future1 = service.submit(task1);
        Future<List<Integer>> future2 = service.submit(task2);
        Future<List<Integer>> future3 = service.submit(task3);
        Future<List<Integer>> future4 = service.submit(task4);
        future1.get();
        future2.get();
        future3.get();
        future4.get();
        end   = System.currentTimeMillis();
        System.out.println(end - start);

    }

    static class ComputingPrime implements Callable<List<Integer>> {
        private int start;
        private int end;

        public ComputingPrime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public List<Integer> call() throws Exception {
            return getPrimes(start,end);
        }
    }


    static boolean isPrime(int num){
        for (int i = 2; i < num/2; i++) {
            if(num % i == 0) return  false;
        }
        return true;
    }

    static List<Integer> getPrimes(int start,int end){
        List<Integer> list = new ArrayList();
        for (int i = start; i <= end; i++) {
            if(isPrime(i)){
                list.add(i);
            }
        }
        return list;
    }


}
