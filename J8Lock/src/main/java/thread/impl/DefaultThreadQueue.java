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

    }

    public Runnable take() {
        return null;
    }

    public int size() {
        return 0;
    }
}
