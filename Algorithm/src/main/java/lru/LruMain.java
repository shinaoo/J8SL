package lru;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class LruMain {
    public static void main(String[] args){

//        System.out.println("mem max:" + Runtime.getRuntime().maxMemory() + " free:" + Runtime.getRuntime().freeMemory() + " to:" + Runtime.getRuntime().totalMemory());
        LruCache lruCache = new LruCache();
//        Stream.of(1,2,3,4,5,1).forEach(position->{
//            lruCache.addKeyValue(""+position,"this is my position:" + position);
//        });
//        for (int i = 0;i < 6000000;i++){
//            lruCache.addKeyValue("" + i,"this is position:" + i);
//        }
        LongStream.range(0,10000000).forEach(count ->{
            lruCache.addKeyValue(count+"","position:" + count);
            if (count % 50000 == 0){
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        lruCache.printAllKeyValue();
    }
}
