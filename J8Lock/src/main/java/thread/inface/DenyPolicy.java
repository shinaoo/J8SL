package thread.inface;

public interface DenyPolicy {
    void reject(Runnable runnable,ThreadPool threadPool);
}
