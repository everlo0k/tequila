package cn.bigears.base.context;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * ContextSwitchTest 设计两个线程相互挂起自己,唤醒对方
 * http://ifeve.com/from-javaeye-false-sharing/
 * @author shenyang
 * @date 2021/7/7
 */
public class ContextSwitchTest {

    private static final int RUNS = 3;
    private static final int ITERATES = 1000000;
    private static AtomicReference<Thread> turn = new AtomicReference<>();

    static final class WorkerThread extends Thread {
        volatile Thread other;
        volatile int parks;

        public void run() {
            final AtomicReference<Thread> t = turn;
            final Thread other = this.other;
            if (turn == null || other == null)
                throw new NullPointerException();
            int p = 0;
            for (int i = 0; i < ITERATES; ++i) {
                // 如果t中当前对象是other,替换成this
                while (!t.compareAndSet(other, this)) {
                    // 如果替换不成功,说明t中的other已经被替换(及t中己经是自己),则挂起当前线程
                    LockSupport.park();
                    ++p;
                }
                // 如果成功,唤醒other线程
                LockSupport.unpark(other);
            }
            LockSupport.unpark(other);
            parks = p;
            System.out.println("parks: " + p);
        }
    }

    private static void test() throws Exception {
        WorkerThread a = new WorkerThread();
        WorkerThread b = new WorkerThread();
        a.other = b;
        b.other = a;
        turn.set(a);
        long startTime = System.nanoTime();
        a.start();
        b.start();
        a.join();
        b.join();
        long endTime = System.nanoTime();
        int parkNum = a.parks + b.parks;
        System.out.println("Average time: " + ((endTime - startTime) / parkNum) + "ns");
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < RUNS; i++) {
            test();
        }
    }


}
