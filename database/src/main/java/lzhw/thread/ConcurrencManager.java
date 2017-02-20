package lzhw.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by admin on 2017/2/14.
 */
public class ConcurrencManager {

    private CountDownLatch countDownLatch;
    private int count;
    private Runnable runnable;

    public ConcurrencManager(){

    }
    public ConcurrencManager(int count,Runnable runnable){
        this.countDownLatch = new CountDownLatch(count);
        this.runnable = runnable;
        this.count = count;
    }
    public void start(){
        for (int i = 0; i < this.count ; i++) {
            try {
                new Thread(new ProxyThread(countDownLatch,runnable)).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConcurrencManager concurrencManager = new ConcurrencManager(10,new TestThread());
        concurrencManager.start();
    }

}
 class  TestThread implements Runnable{


    public void run() {
        System.out.println(System.currentTimeMillis());

    }
}