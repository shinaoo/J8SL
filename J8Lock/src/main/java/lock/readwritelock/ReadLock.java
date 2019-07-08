package lock.readwritelock;

import lock.Lock;

public class ReadLock implements Lock {

    private ReadWriteLockImpl readWriteLock;

    public ReadLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMutex()){
            while (readWriteLock.getWritingCount() > 0 || readWriteLock.isPreferWrite()&&readWriteLock.getWaitingWritingCount() > 0){
                readWriteLock.getMutex().wait();
            }
            readWriteLock.incrementReadingCount();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMutex()){
            readWriteLock.decrementReadingCount();
            readWriteLock.setPreferWrite(true);
            readWriteLock.getMutex().notifyAll();
        }
    }
}
