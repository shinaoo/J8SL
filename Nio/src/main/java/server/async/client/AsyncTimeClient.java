package server.async.client;

public class AsyncTimeClient {
    public static void main(String[] args){
        int port = 8080;
        new Thread(new AsyncTimeClientHandler("127.0.0.1",port),"AIO-AsyncTimeClientHandler-001").start();
    }
}
