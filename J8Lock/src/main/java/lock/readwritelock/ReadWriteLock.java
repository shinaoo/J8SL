package lock.readwritelock;

import lock.Lock;

public interface ReadWriteLock {
    Lock getReadLock();
    Lock getWriteLock();

    int getWritingCount();
    int getReadingCount();
    int getWaitingWritingCount();

    static ReadWriteLock getReadWriteLock(){
        return new ReadWriteLockImpl();
    }

}
