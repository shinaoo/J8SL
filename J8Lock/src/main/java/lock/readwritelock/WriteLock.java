package lock.readwritelock;

import lock.Lock;

import java.util.concurrent.locks.ReadWriteLock;

public class WriteLock implements Lock {

    private ReadWriteLockImpl readWriteLock;

    public WriteLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMutex()) {
            try {
                readWriteLock.incrementWaitWritingCount();
                while (readWriteLock.getReadingCount() > 0 || readWriteLock.getWritingCount() > 0) {
                    readWriteLock.getMutex().wait();
                }
            } finally {
                readWriteLock.decrementWaitWritingCount();
            }
            readWriteLock.incrementWritingCount();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMutex()) {
            readWriteLock.decrementWritingCount();
            readWriteLock.setPreferWrite(false);
            readWriteLock.getMutex().notifyAll();
        }
    }
}
