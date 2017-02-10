package lzhw.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by admin on 2017/2/14.
 */
public class ProxyThread implements Runnable{
    private CountDownLatch countDownLatch;
    private Runnable runnable;

    public ProxyThread(CountDownLatch countDownLatch,Runnable runnable){
        this.countDownLatch = countDownLatch;
        this.runnable = runnable;
    }
    public void run() {
        countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runnable.run();
    }
}
