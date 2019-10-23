package cn.bigears.base.threadlocal;

import java.util.concurrent.ThreadLocalRandom;

/**
 * ThreadLocalTest
 * @author shenyang
 * @date 2019/10/10
 */
public class ThreadLocalTest {

    private static final int RETRY_TIMES = 5;
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 10);
    /**
     * 这里定义ThreadLocalRandom是不对的,这个RANDOM实际是和当前主线程相关的
     * 正式的使用的方法,是在每个线程中独立使用
     */
    // private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void main(String[] args) {
        for (int i = 0; i < RETRY_TIMES; i++) {
            new Member().start();
        }

    }
    public static class Member extends Thread {
        @Override
        public void run() {
            System.out.println(threadLocal.get() - ThreadLocalRandom.current().nextInt(10));
            threadLocal.set(20);
            System.out.println(threadLocal.get());
            threadLocal.remove();
        }
    }

}
