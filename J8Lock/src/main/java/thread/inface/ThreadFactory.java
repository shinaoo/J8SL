package thread.inface;

public interface ThreadFactory {
    Thread createThread(Runnable runnable);
}
