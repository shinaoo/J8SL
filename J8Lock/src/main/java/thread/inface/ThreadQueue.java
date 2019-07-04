package thread.inface;

public interface ThreadQueue {
    public void offer(Runnable runnable);
    Runnable take();
    int size();
}
