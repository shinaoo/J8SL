package event.driven.async;

import event.driven.sync.Event;
import event.driven.sync.EventDispatcherExample;

import java.util.concurrent.TimeUnit;

public class AsyncEventDispatchExample {
    static class AsyncInputEventHandler extends AsyncChannel{
        private final AsyncEventDispatcher dispatcher;
        AsyncInputEventHandler(AsyncEventDispatcher dispatcher){
            this.dispatcher = dispatcher;
        }

        @Override
        protected void handle(Event message) {
            EventDispatcherExample.InputEvent inputEvent = (EventDispatcherExample.InputEvent) message;
            System.out.printf("X:%d,Y:%d",inputEvent.getX(),inputEvent.getY());
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            int result = inputEvent.getX() + inputEvent.getY();
            dispatcher.dispatch(new EventDispatcherExample.ResultEvent(result));
        }
    }

    static class AsyncResultEventHandler extends AsyncChannel{
        @Override
        protected void handle(Event message) {
            EventDispatcherExample.ResultEvent resultEvent = (EventDispatcherExample.ResultEvent) message;
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.printf("The result is :" + resultEvent.getResult());
        }
    }
}
