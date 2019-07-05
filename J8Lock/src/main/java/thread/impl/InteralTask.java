package thread.impl;

import thread.inface.ThreadQueue;

public class InteralTask implements Runnable{

    private final ThreadQueue threadQueue;
    private volatile boolean running = true;

    public InteralTask(ThreadQueue threadQueue) {
        this.threadQueue = threadQueue;
    }

    @Override
    public void run() {
        while (running & ! Thread.currentThread().isInterrupted()){
            try {
                Runnable task = threadQueue.take();
                task.run();
            }catch (InterruptedException e){
                running = false;
                break;
            }
        }
    }

    public void stop(){
        this.running = false;
    }
}
