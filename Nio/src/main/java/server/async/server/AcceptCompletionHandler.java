package server.async.server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel,AsyncTimeServerHandle> {

    public AcceptCompletionHandler() {
    }

    @Override
    public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandle attachment) {
        attachment.asynchronousServerSocketChannel.accept(attachment,this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer,buffer,new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHandle attachment) {
        attachment.latch.countDown();
    }
}
