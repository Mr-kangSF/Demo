package com.wankang.demo.service.MarkOneDayAsk;

/**
 * https://segmentfault.com/n/1330000019799723
 *
 * @author wankang
 * @create 2019-07-18 20:31
 **/
public class Lazy {
    private static boolean initialized = false;

    static {
        Thread t = new Thread(() -> initialized = true);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(initialized);
    }
}
