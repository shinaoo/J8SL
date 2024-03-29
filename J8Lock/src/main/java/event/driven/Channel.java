package event.driven;

public interface Channel<E extends Message> {
    //dispatch用于负责Message的调度
    void dispatch(E message);
}
