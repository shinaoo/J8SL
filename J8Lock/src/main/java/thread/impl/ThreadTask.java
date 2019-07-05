package thread.impl;

//只是InternalTask和Thread的一个组合
public class ThreadTask {

    Thread thread;
    InteralTask interalTask;

    public ThreadTask(Thread thread, InteralTask interalTask) {
        this.thread = thread;
        this.interalTask = interalTask;
    }
}
