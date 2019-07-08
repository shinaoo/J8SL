package lock.singlelock;

import lock.Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShareObject {

    private Lock singleLock = new SingleLock();

    private List<Character> chars = new ArrayList<>();
    private int length;

    public ShareObject(int length) {
        this.length = length;
    }

    public char[] read() throws InterruptedException {
        try {
            singleLock.lock();
            char[] result = new char[chars.size()];
            for (int i = 0;i < length;i++){
                result[i] = chars.get(i);
            }
            System.out.println(Thread.currentThread().getName() + "is reading:" + new String(result));
            slowly();
            return result;
        }finally {
            singleLock.unlock();
        }

    }

    public void write(char c){
        try {
            singleLock.lock();
            System.out.println(Thread.currentThread().getName()+"is writing:" + c);
            for (int i = 0;i < length;i ++){
                chars.add(i,c);
            }
            slowly();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            singleLock.unlock();
        }
    }

    private void slowly(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

