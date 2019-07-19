package server.async.server;

public class AsyncChannelServer {

    public static void main(String[] args){
        int port = 8080;

        AsyncTimeServerHandle timeServerHandle = new AsyncTimeServerHandle(port);
        new Thread(timeServerHandle,"AIO-AsyncTimeServerHandler---1").start();
    }

}
