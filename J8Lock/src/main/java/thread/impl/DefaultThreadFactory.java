package thread.impl;

import thread.inface.ThreadFactory;

public class DefaultThreadFactory implements ThreadFactory {

    public Thread createThread(Runnable runnable) {
        return new Thread(runnable);
    }
}
