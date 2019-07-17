package event.driven.async;

import event.driven.sync.EventDispatcherExample;

public class AsyncDrivenMain {
    public static void main(String[] args){
        AsyncEventDispatcher dispatcher = new AsyncEventDispatcher();
        dispatcher.registerChannel(EventDispatcherExample.InputEvent.class,new AsyncEventDispatchExample.AsyncInputEventHandler(dispatcher));
        dispatcher.registerChannel(EventDispatcherExample.ResultEvent.class,new AsyncEventDispatchExample.AsyncResultEventHandler());
        dispatcher.dispatch(new EventDispatcherExample.InputEvent(3,5));
        dispatcher.shutdown();
    }
}
