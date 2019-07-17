package event.driven.async;

import event.driven.Channel;
import event.driven.DynamicRouter;
import event.driven.sync.Event;
import event.driven.sync.MessageMatcherException;

import java.util.HashMap;
import java.util.Map;

public class AsyncEventDispatcher implements DynamicRouter<Event> {

    private final Map<Class<? extends Event>,AsyncChannel> routerTable;

    public AsyncEventDispatcher() {
        this.routerTable = new HashMap<>();
    }

    @Override
    public void registerChannel(Class<? extends Event> messageType, Channel<? extends Event> channel) {
        if (!(channel instanceof AsyncChannel)){
            throw new IllegalArgumentException("The channel must be AsyncChannel Type");
        }
        this.routerTable.put(messageType,(AsyncChannel)channel);
    }

    @Override
    public void dispatch(Event message) {
        if (routerTable.containsKey(message.getType())){
            routerTable.get(message.getType()).dispatch(message);
        }else
            throw new MessageMatcherException("Can't match the channel for [" + message.getType() +"] type");
    }

    public void shutdown(){
        routerTable.values().forEach(AsyncChannel::stop);
    }
}
