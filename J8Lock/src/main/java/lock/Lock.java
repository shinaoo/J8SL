package lock;

public interface Lock {
    void lock() throws InterruptedException;
    void unlock();
}
