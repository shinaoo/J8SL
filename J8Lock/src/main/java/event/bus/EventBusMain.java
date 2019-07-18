package event.bus;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class EventBusMain {
    public static void main(String[] args){

        //同步EventBus
        Bus bus = new EventBus("TestBus");
        bus.register(new SimpleSubscriber1());
        bus.register(new SimpleSubscriber2());
        bus.post("hello");
//        bus.post("Hlllooooooo","test");

        // 异步EventBus
        Bus abus = new AsyncEventBus("TestBus", (ThreadPoolExecutor) Executors.newFixedThreadPool(10));
        abus.register(new SimpleSubscriber1());
        abus.register(new SimpleSubscriber2());
        abus.post("Hello");

    }
}
