package event.bus;

public interface Bus {
    //将某个对象注册到Bus上,该类就成为Subscriber了
    void register(Object subscriber);
    //将某个对象从Bus上取消注册
    void unregister(Object subscriber);
    //提交Event到默认的topic
    void post(Object event);
    //提交Event到指定的Topic
    void post(Object event,String topic);
    //关闭bug
    void close();
    //返回Bus的名称标识
    String getBusName();
}
