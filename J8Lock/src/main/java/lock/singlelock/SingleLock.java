package lock.singlelock;

import lock.Lock;

public class SingleLock implements Lock {
    private final Object mutex = new Object();

    private boolean lock = false;
    @Override
    public void lock() throws InterruptedException {
        synchronized (mutex){
            while(!lock){
                mutex.wait();
            }
            lock = true;
        }
    }

    @Override
    public void unlock() {
        synchronized (mutex){
            lock = false;
            mutex.notifyAll();
        }
    }
}
