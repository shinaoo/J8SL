package event.bus;

public interface EventExceptionHandler {
    void handle(Throwable cause,EventContext context);
}
