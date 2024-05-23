package org.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类  判断 通知 干活
 *
 * @Author: eternity
 */
class Resource {
    private int num = 0;

    private volatile Lock lock = new ReentrantLock();
    Condition addCon = lock.newCondition();
    Condition delCon = lock.newCondition();

    /**
     * +1
     */
    public void add() throws Exception {
        lock.lock();
        try {
            // 防止虚假唤醒
            while (num != 0) {
                // 等待
                addCon.await();
            }
            ++num;
            System.out.println(Thread.currentThread().getName() + "\t" + "执行加操作，当前数字为" + num);
            // 唤醒
            if (num == 1) {
                delCon.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * -1
     */
    public void del() throws Exception {
        // block until condition holds
        lock.lock();
        try {
            // 防止虚假唤醒
            while (num != 1) {
                // 等待
                delCon.await();
            }
            --num;
            System.out.println(Thread.currentThread().getName() + "\t" + "执行减操作，当前数字为" + num);
            // 唤醒
            if (num == 0) {
                addCon.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 生消模型
 * 20个线程操作加，每个线程操作10次
 * 20个线程操作减，每个线程操作10次
 * <p>
 * 线程超过被操作（加、减）的个数，会造成虚假唤醒。
 * 虚假唤醒（spurious wakeup）是指一个线程在没有被 signal 或广播的情况下，从等待队列中醒来。
 * <p>
 * 造成虚假唤醒的原因通常是操作系统内核或硬件提供的设施的实现，而不是由 Java 语言本身引起的。
 * <p>
 * 为了避免虚假唤醒，可以在 while 循环中使用 wait() 方法进行阻塞等待，同时在 while 循环中使用条件判断，防止在没有满足条件时进行唤醒。例如：
 * synchronized (obj) {
 * while (!condition) {
 * obj.wait();
 * }
 * // do something else
 * }
 * 在使用 wait() 方法进行等待时，必须在锁对象上进行调用，否则会抛出 IllegalMonitorStateException 异常。
 * <p>
 * 除此之外，还可以使用 LockSupport.park() 方法进行阻塞等待，同样需要在 while 循环中进行防护。
 *
 * @Author: eternity
 */
public class ProdConsumerLock {
    public static void main(String[] args) {
        // 资源
        Resource resource = new Resource();
//        // 20个线程操作加，每个线程操作10次
//        for (int i = 0; i < 20; i++) {
//            new Thread(() -> {
//                for (int j = 1; j <= 10; j++) {
//                    try {
//                        resource.add();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }
//
//        // 20个线程操作减，每个线程操作10次
//        for (int i = 0; i < 20; i++) {
//            new Thread(() -> {
//                for (int j = 1; j <= 10; j++) {
//                    try {
//                        resource.del();
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }

        //使用线程池操作执行操作阻塞进行  pool-1-thread-1	执行加操作，当前数字为1 后阻塞
        // 线程池
//        ExecutorService threadPool = MyThreadPool.getMyThreadPool();
        ExecutorService threadPool = Executors.newFixedThreadPool(21);
        for (int i = 0; i < 20; i++) {
            threadPool.execute(() -> {
                for (int j = 1; j <= 10; j++) {
                    try {
                        resource.add();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // 20个线程操作减，每个线程操作10次
        for (int i = 0; i < 20; i++) {
            threadPool.execute(() -> {
                for (int j = 1; j <= 10; j++) {
                    try {
                        resource.del();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}