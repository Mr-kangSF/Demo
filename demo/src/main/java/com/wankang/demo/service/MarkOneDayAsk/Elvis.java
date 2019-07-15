package com.wankang.demo.service.MarkOneDayAsk;

import java.util.Calendar;

/**
 * static 初始化顺序
 *
 * @author wankang
 * @create 2019-07-15 19:53
 **/
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private final int beltSize;

    private static final int CURRENT_YEAR =
            Calendar.getInstance().get(Calendar.YEAR);

    private Elvis() {
        beltSize = CURRENT_YEAR - 1930;
    }

    public int beltSize() {
        return beltSize;
    }

    public static void main(String[] args) {
        System.out.println("Elvis wears size " +
                INSTANCE.beltSize() + " belt.");
    }
}
