package lru;

import java.util.*;

public class LruCache {

    private List<String> queue = new LinkedList<>();
    private Map<String,String> cache = new HashMap<>(40,0.9f);
    private long cacheMemory = 0;
    private long useMemory = 0;

    public LruCache(){
        init();
    }

    private void init(){
        cacheMemory = Runtime.getRuntime().maxMemory() >> 2;
    }

    public String  get(String key){
        return cache.get(key);
    }

    public void addKeyValue(String key,String value){
        System.out.println("key:" + key + " mem:" + cacheMemory + " use:" + useMemory);
        if (cache.containsKey(key)){
            useMemory -= cache.get(key).getBytes().length;
            queue.remove(key);
        }
        if (useMemory + value.getBytes().length > cacheMemory){
            recursiveSubMemory(value.getBytes().length);
        }
        cache.put(key,value);
        queue.add(0,key);
        useMemory+=value.getBytes().length;
    }

    private void recursiveSubMemory(int next){
        cache.remove(queue.get(queue.size()-1));
        useMemory = useMemory - queue.get(queue.size()-1).getBytes().length;
        if (useMemory + next > cacheMemory){
            recursiveSubMemory(next);
        }
    }

    public void printAllKeyValue(){
        cache.forEach((key,value) -> {
            System.out.println("key:" + key + " value:" + value);
        });
        System.out.println("cacheMemory:" + cacheMemory + " use:" + useMemory);
    }


}
