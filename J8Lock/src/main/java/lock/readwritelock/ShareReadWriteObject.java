package lock.readwritelock;

import lock.Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShareReadWriteObject {

    private List<Character> resources = new ArrayList<>();
    private int length;

    private Lock readLock = ReadWriteLock.getReadWriteLock().getReadLock();
    private Lock writeLock = ReadWriteLock.getReadWriteLock().getWriteLock();

    public ShareReadWriteObject(int length) {
        this.length = length;
    }

    public char[] read() throws InterruptedException {
        try {
            readLock.lock();
            char[] result = new char[resources.size()];
            for (int i = 0;i < length;i++){
                result[i] = resources.get(i);
            }
            System.out.println(Thread.currentThread().getName() + "is reading:" + new String(result));
            slowly();
            return result;
        }finally {
            readLock.unlock();
        }

    }

    public void write(char c){
        try {
            writeLock.lock();
            System.out.println(Thread.currentThread().getName()+"is writing:" + c);
            for (int i = 0;i < length;i ++){
                resources.add(i,c);
            }
            slowly();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }


    private void slowly(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
