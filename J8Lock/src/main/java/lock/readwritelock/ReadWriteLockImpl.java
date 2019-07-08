package lock.readwritelock;

import lock.Lock;

public class ReadWriteLockImpl implements ReadWriteLock {

    private Object mutex = new Object();

    private int writingCount = 0;
    private int waitWritingCount = 0;
    private int readingCount = 0;

    //没有加上这个偏好的时候,都是写锁的线程获取.
    private boolean preferWrite = false;

    public ReadWriteLockImpl() {
    }

    @Override
    public Lock getReadLock() {
        return new ReadLock(this);
    }

    @Override
    public Lock getWriteLock() {
        return new WriteLock(this);
    }

    @Override
    public int getWritingCount() {
        return this.writingCount;
    }

    @Override
    public int getReadingCount() {
        return this.readingCount;
    }

    @Override
    public int getWaitingWritingCount() {
        return this.waitWritingCount;
    }

    public void incrementWritingCount(){
        this.writingCount++;
    }
    public void incrementReadingCount(){
        this.readingCount++;
    }
    public void incrementWaitWritingCount(){
        this.waitWritingCount++;
    }
    public void decrementWritingCount(){
        this.writingCount--;
    }
    public void decrementReadingCount(){
        this.readingCount--;
    }
    public void decrementWaitWritingCount(){
        this.waitWritingCount--;
    }
    public Object getMutex(){
        return this.mutex;
    }

    public void setPreferWrite(boolean preferWrite) {
        this.preferWrite = preferWrite;
    }

    public boolean isPreferWrite() {
        return this.preferWrite;
    }
}
