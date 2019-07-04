package thread.impl;

import thread.inface.DenyPolicy;
import thread.inface.ThreadPool;
import thread.inface.ThreadQueue;

import java.util.LinkedList;
import java.util.List;

public class DefaultThreadQueue implements ThreadQueue {

    private LinkedList<Runnable> threads = new LinkedList<>();
    private int limit;
    private ThreadPool threadPool;
    private DenyPolicy denyPolicy;

    public DefaultThreadQueue(int limit, ThreadPool threadPool, DenyPolicy denyPolicy) {
        this.limit = limit;
        this.threadPool = threadPool;
        this.denyPolicy = denyPolicy;
    }

    public void offer(Runnable runnable) {
        synchronized (threads) {
            if (threads.size() >= limit) {
                denyPolicy.reject(runnable, threadPool);
            } else {
                threads.addLast(runnable);
                threads.notifyAll();
            }
        }
    }

    public Runnable take() throws InterruptedException {
        synchronized (threads) {
            while (threads.isEmpty()) {
                try {
                    threads.wait();
                }catch (InterruptedException e){
                    throw e;
                }
            }
            return threads.removeFirst();
        }
    }

    public int size() {
        synchronized (threads){
            return threads.size();
        }
    }
}
