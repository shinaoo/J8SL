package lru;

import java.util.stream.Stream;

public class LruMain {
    public static void main(String[] args){

//        System.out.println("mem max:" + Runtime.getRuntime().maxMemory() + " free:" + Runtime.getRuntime().freeMemory() + " to:" + Runtime.getRuntime().totalMemory());
        LruCache lruCache = new LruCache();
        Stream.of(1,2,3,4,5,1).forEach(position->{
            lruCache.addKeyValue(""+position,"this is my position:" + position);
        });
        lruCache.printAllKeyValue();
    }
}
