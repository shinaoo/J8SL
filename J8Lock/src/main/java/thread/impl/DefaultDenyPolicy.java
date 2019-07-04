package thread.impl;

import thread.inface.DenyPolicy;
import thread.inface.ThreadPool;

public class DefaultDenyPolicy implements DenyPolicy {

    public void reject(Runnable runnable, ThreadPool threadPool) {
        runnable.run();
    }
}
