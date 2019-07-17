package event.driven;

public interface DynamicRouter<E extends Message> {
    //针对每一个Message类型注册相关的Channel,只有找到合适的Channel，该Message才会被处理
    void registerChannel(Class<? extends E> messageType,Channel<? extends E> channel);
    //为相应的Channel分配Message
    void dispatch(E message);
}
