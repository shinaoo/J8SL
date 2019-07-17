package event.driven.sync;

import event.driven.Channel;

public class EventDispatcherExample {

    //InputEvent中定义了X和Y，主要用于的其它Channel中运算
    static class InputEvent extends Event{
        private final int x;
        private final int y;
        public InputEvent(int x,int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    //存放结果的Event
    static class ResultEvent extends Event{
        private final int result;
        public ResultEvent(int result){
            this.result = result;
        }

        public int getResult() {
            return result;
        }
    }

    static class ResultEventHandler implements Channel<ResultEvent> {

        @Override
        public void dispatch(ResultEvent message) {
            System.out.println("The result is " + message.getResult());
        }
    }

    static class InputEventHandler implements Channel<InputEvent>{
        private final EventDispatcher dispatcher;
        public InputEventHandler(EventDispatcher eventDispatcher){
            this.dispatcher = eventDispatcher;
        }

        @Override
        public void dispatch(InputEvent message) {
            System.out.printf("X:%d,Y:%d\n",message.getX(),message.getY());
            int result = message.getX() + message.getY();
            dispatcher.dispatch(new ResultEvent(result));
        }
    }


}
