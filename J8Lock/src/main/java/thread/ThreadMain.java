package thread;

import thread.impl.DefaultThreadPool;
import thread.inface.ThreadPool;

import java.util.concurrent.TimeUnit;

/**
 * 实现一个线程池
 */
public class ThreadMain {
    public static void main(String[] args) throws InterruptedException{
        //测试ThreadPool
        ThreadPool threadPool = new DefaultThreadPool(2,6,4);
        for (int i = 0;i < 20;i++){
            threadPool.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "is done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        for (; ; ) {
            System.out.println("getActiveCount:" + threadPool.getActiveCount() + " max:" + threadPool.getMaxSize() + " queuesize:" + threadPool.getQueueSize());
            System.out.println("===========================================");
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
