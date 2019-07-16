package com.wankang.demo.service.java8;

import com.wankang.demo.dto.Dish;

import java.util.stream.Collectors;

import static com.wankang.demo.dto.Dish.menu;

/**
 * ${DESCRIPTION}
 *
 * @author wankang
 * @create 2019-07-16 9:39
 **/
public class StreamTest08 {

    public static void main(String [] args) {
        test01();
    }

    // joining
    private static void test01() {
        String collect = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(collect);
    }

}
