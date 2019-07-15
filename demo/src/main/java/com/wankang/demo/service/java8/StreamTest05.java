package com.wankang.demo.service.java8;

import com.wankang.demo.dto.Dish;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.wankang.demo.dto.Dish.menu;

/**
 * 数值流
 *
 * @author wankang
 * @create 2019-07-15 11:00
 **/
public class StreamTest05 {

    public static void main(String... args) {
//        test01();
//        test02();
//        test03();
        test04();
    }

    // 卡路里求和
    private static void test01() {
        int sum = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        System.out.println(sum);
    }

    // 数值流转回对象流
    private static void test02() {
        // stream转换为数值流
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);

        // 数值流转换为Stream
        Stream<Integer> boxed = intStream.boxed();
    }

    // 数值流求最大值
    private static void test03() {
        OptionalInt max = menu.stream().mapToInt(Dish::getCalories).max();
        int result = max.orElse(1);

        System.out.println("最大值为：" + result);
    }

    // 数值流 数值范围
    private static void test04() {
        // 过滤1-100之间的偶数
//        IntStream intStream = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);   // [1,100]
        IntStream intStream = IntStream.range(1, 100).filter(n -> n % 2 == 0);   // [1,100)

        System.out.println(intStream.count());
    }





}
