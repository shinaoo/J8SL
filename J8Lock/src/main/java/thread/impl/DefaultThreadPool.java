package thread.impl;

import thread.inface.DenyPolicy;
import thread.inface.ThreadFactory;
import thread.inface.ThreadPool;
import thread.inface.ThreadQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class DefaultThreadPool extends Thread implements ThreadPool {

    private int initSize;
    private int maxSize;
    private int coreSize;
    private DenyPolicy denyPolicy;
    private ThreadQueue threadQueue;
    private ThreadFactory threadFactory = new DefaultThreadFactory();
    private long keepLiveTime = 10;
    private volatile boolean isShutdown = false;
    private Queue<ThreadTask> workThreadQueue = new ArrayDeque<>();
    private int activeCount = 0;
    private TimeUnit timeUnit;

    public DefaultThreadPool(int initSize, int maxSize, int coreSize) {
        this(initSize,maxSize,coreSize,10,false,TimeUnit.SECONDS);
    }

    public DefaultThreadPool(int initSize, int maxSize, int coreSize, long keepLiveTime, boolean isShutdown,TimeUnit timeUnit) {
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.keepLiveTime = keepLiveTime;
        this.isShutdown = isShutdown;
        this.threadQueue = new DefaultThreadQueue(100,this,denyPolicy);
        this.timeUnit = timeUnit;
        init();
    }

    @Override
    public void execute(Runnable runnable) {
        if (this.isShutdown)
            throw new IllegalStateException("thread pool already destroyed");
        this.threadQueue.offer(runnable);
    }

    @Override
    public void shutdown() {
        synchronized (this){
            if (isShutdown)
                return;
            isShutdown = true;
            workThreadQueue.forEach(threadTask -> {
                threadTask.interalTask.stop();
                threadTask.thread.interrupt();
            });
            this.interrupt();
        }
    }

    @Override
    public int getInitSize() {
        if (isShutdown)
            throw new IllegalStateException("thread pool already destroyed");
        return this.initSize;
    }

    @Override
    public int getMaxSize() {
        if (isShutdown)
            throw new IllegalStateException("thread pool already destroyed");
        return this.maxSize;
    }

    @Override
    public int getQueueSize() {
        if (isShutdown)
            throw new IllegalStateException("thread pool already destroyed");
        return this.threadQueue.size();
    }

    @Override
    public int getActiveCount() {
        return this.activeCount;
    }

    @Override
    public boolean isShutdown() {
        return this.isShutdown;
    }

    @Override
    public void run() {
        while (!isShutdown && !isInterrupted()){
            try {
                timeUnit.sleep(keepLiveTime);
            }catch (InterruptedException e){
                isShutdown = true;
                break;
            }
            synchronized (this){
                if (isShutdown)
                    break;
                if (threadQueue.size() > 0 && activeCount < coreSize){
                    for (int i = initSize;i < coreSize;i++){
                        newThread();
                    }
                    continue;
                }
                if (threadQueue.size() > 0 && activeCount < maxSize){
                    for (int i =coreSize;i < maxSize;i++){
                        newThread();
                    }
                }
                if (threadQueue.size() == 0 && activeCount >coreSize){
                    for (int i = coreSize;i < activeCount;i++){
                        removeThread();
                    }
                }
            }
        }
    }

    private void init(){
        start();
        for(int i = 0;i < initSize;i ++){
            newThread();
        }
    }

    private void newThread(){
        InteralTask interalTask = new InteralTask(threadQueue);
        Thread thread = this.threadFactory.createThread(interalTask);
        ThreadTask threadTask = new ThreadTask(thread,interalTask);
        workThreadQueue.offer(threadTask);
        this.activeCount ++;
        thread.start();
    }

    private void removeThread(){
        ThreadTask threadTask = workThreadQueue.remove();
        threadTask.interalTask.stop();
        this.activeCount--;
    }

}
