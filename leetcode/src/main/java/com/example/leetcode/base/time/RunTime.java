package com.example.leetcode.base.time;

/**
 * @author quanshibao
 * @description
 * @date 2021/4/15
 */
public class RunTime {
    public static final String TAG = "qsg";

    public interface Algorithm {
        Object execute();
    }

    public static void msRun(Algorithm algorithm) {
        Thread thread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            System.out.println("sTime = " + startTime);
            System.out.println(algorithm.execute());
            long endTime = System.currentTimeMillis();
            System.out.println("eTime = " + endTime);
            System.out.println(" 耗时：" + (endTime - startTime) + " ms");
        });
        thread.start();
    }

    public static void nsRun(Algorithm algorithm) {
        Thread thread = new Thread(() -> {
            long startTime = System.nanoTime();
            System.out.println("sTime = " + startTime);
            System.out.println(algorithm.execute());
            long endTime = System.nanoTime();
            System.out.println("eTime = " + endTime);
            System.out.println(" 耗时：" + (endTime - startTime) + " ns");
        });
        thread.start();
    }


}
