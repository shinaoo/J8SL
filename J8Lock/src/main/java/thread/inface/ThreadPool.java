package thread.inface;

public interface ThreadPool {

    void execute(Runnable runnable);
    void shutdown();
    int getInitSize();
    int getMaxSize();
    int getQueueSize();
    int getActiveCount();
    boolean isShutdown();

}
