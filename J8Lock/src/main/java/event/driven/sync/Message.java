package event.driven.sync;

public interface Message {
    //返回消息类型
    Class<? extends Message> getType();
}
