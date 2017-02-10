package lzhw.utils;

import lzhw.thread.ConcurrencManager;

/**
 * Created by admin on 2017/2/14.
 */
public class SequenceGenerator {
    public static long sequence = 0;

    public synchronized static long getSequence(){
        return sequence++;
    }
    public synchronized static String getStrSequence(){
        return String.format("%03d",getSequence());
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(String.format("%03d",getSequence()));
            }
        };
        ConcurrencManager concurrencManager = new ConcurrencManager(100,runnable);
        concurrencManager.start();
    }
}
