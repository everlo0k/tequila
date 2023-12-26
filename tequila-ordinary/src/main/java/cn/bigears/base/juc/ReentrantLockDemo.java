package cn.bigears.base.juc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockDemo
 * @author shenyang
 * @date 2022/2/8
 */
public class ReentrantLockDemo {

    private static Lock lock = new ReentrantLock();

    private static final ThreadFactory REENTRANT_LOCK_DEMO_THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("reentrantLockDemoThreadFactory").build();

    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 20, 120, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10000), REENTRANT_LOCK_DEMO_THREAD_FACTORY);


    private static void lockTest(int i) {
        try {
            lock.lock();
            System.out.println(i + Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        int size = 10;
        for (int i = 0; i < size; i++) {
            int finalI = i;
            reentrantLockDemo.threadPoolExecutor.execute(() -> ReentrantLockDemo.lockTest(finalI));
        }

    }

}
