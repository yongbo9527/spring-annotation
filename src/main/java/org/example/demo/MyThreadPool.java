package org.example.demo;

import java.util.concurrent.*;

/**
 * @Author: Ron
 * @Create: 2023-07-20 9:37
 */
public class MyThreadPool {
    /**
     * 手动实现线程池
     * 最大线程数设置：
     * CPU密集型：CPU核数+1
     * IO密集型：CPU核数/ 1- 阻塞系数 （阻塞系数在0.8 ~ 0.9之间）
     * 例如：16 / 1 - 0.9 = 160
     *
     * @return ExecutorService
     */
    public static ExecutorService getMyThreadPool() {
//查看本机CPU核数
        System.out.println("本机CPU核数 :" + Runtime.getRuntime().availableProcessors());

        return new ThreadPoolExecutor(
//线程池中的常驻核心线程数
                16,
//线程池中能够容纳同时执行的最大线程数（线程池最大数）
                17,
//多余的空闲线程的存活时间
                20L,
//多余的空闲线程的存活时间的单位(毫秒)
                TimeUnit.MILLISECONDS,
//阻塞队列（有界）(相当于银行的候客区)
                new LinkedBlockingQueue<Runnable>(300),
//线程工厂，默认的 new DefaultThreadFactory()
                Executors.defaultThreadFactory(),
/**
 * 第七个参数 线程的拒绝策略：
 * 1.ThreadPoolExecutor.AbortPolicy()//超过最大数加阻塞队列立刻中断并报错java.util.concurrent.RejectedExecutionException
 * 2.ThreadPoolExecutor.DiscardOldestPolicy()//等待时间最长的抛弃
 * 3.ThreadPoolExecutor.CallerRunsPolicy()//调用者回退，（谁分配的去找谁干）
 * 4.ThreadPoolExecutor.DiscardPolicy()//不处理，直接丢弃
 */
//拒绝策略
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
