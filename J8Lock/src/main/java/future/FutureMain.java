package future;

import java.util.concurrent.TimeUnit;

public class FutureMain {

    public static void main(String[] args) throws InterruptedException{
        FutureService<Void,Void> service = FutureService.newService();
        Future<?> future = service.submit(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("future is finish done");
        });

        FutureService<String,Integer> service1 = FutureService.newService();
        Future<Integer> future1 = service1.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return input.length();
        },"HELLO");
        System.out.println("future1 get:" + future1.get());
    }
}
