package utils;

import java.util.concurrent.atomic.AtomicLong;

public class Atomic {
    private static AtomicLong atomicLong = new AtomicLong(0L);

    public static synchronized String getNum() {
        long andIncrement = atomicLong.getAndIncrement();
        if (andIncrement < 0) {
            atomicLong.set(0);
            andIncrement = 0;
        }
        String str = String.valueOf(andIncrement);
        return str;
    }
}
