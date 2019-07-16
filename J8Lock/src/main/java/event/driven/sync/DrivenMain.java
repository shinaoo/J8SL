package event.driven.sync;

public class DrivenMain {

    public static void main(String[] args){
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(EventDispatcherExample.InputEvent.class,new EventDispatcherExample.InputEventHandler(dispatcher));
        dispatcher.registerChannel(EventDispatcherExample.ResultEvent.class,new EventDispatcherExample.ResultEventHandler());
        dispatcher.dispatch(new EventDispatcherExample.InputEvent(1,2));
    }
}
