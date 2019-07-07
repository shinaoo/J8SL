package lock.singlelock;

import lock.Lock;

import java.util.ArrayList;
import java.util.List;

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
            return result;
        }finally {
            singleLock.unlock();
        }

    }




}

