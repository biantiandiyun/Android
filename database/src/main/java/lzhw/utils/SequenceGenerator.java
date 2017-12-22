package lzhw.utils;

import lzhw.thread.ConcurrencManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by admin on 2017/2/14.
 */
public class SequenceGenerator {
    private static final Log log = LogFactory.getLog(SequenceGenerator.class);
    AtomicLong aLong = new AtomicLong();
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

                System.out.println(getStrSequence());
            }
        };
        ConcurrencManager concurrencManager = new ConcurrencManager(1000,runnable);
        concurrencManager.start();
    }
}
