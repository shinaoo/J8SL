package event.driven.sync;

import event.driven.Message;

public class Event implements Message {

    @Override
    public Class<? extends Message> getType() {
        return getClass();
    }
}
