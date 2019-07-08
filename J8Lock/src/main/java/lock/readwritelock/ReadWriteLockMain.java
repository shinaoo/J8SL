package lock.readwritelock;

import lock.singlelock.ShareObject;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ReadWriteLockMain {
    public static void main(String[] args) {
        String myTestStr = "this is String";

        ShareReadWriteObject shareObject = new ShareReadWriteObject(14);

        IntStream.range(0, 2).forEach(integer -> {
            new Thread(() -> {
                for (int i = 0; i < myTestStr.length(); i++) {
                    char c = myTestStr.charAt(i);
                    shareObject.write(c);
                }
            }).start();
        });

        IntStream.range(0, 4).forEach(integer -> {
            new Thread(() -> {
                try {
                    while (true) {
                        shareObject.read();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });

        for (; ; ) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
