package lzhw.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2017/2/20.
 */
public class ThreadExcuter {
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(500);

    public static void execute(Runnable runnable){
        EXECUTOR.execute(runnable);
    }
}
