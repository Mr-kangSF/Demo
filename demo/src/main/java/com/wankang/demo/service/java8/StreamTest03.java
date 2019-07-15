package com.wankang.demo.service.java8;

import java.util.Arrays;
import java.util.List;

import static com.wankang.demo.dto.Dish.menu;

/**
 * 归约  （折叠）
 *
 * @author wankang
 * @create 2019-07-14 22:39
 **/
public class StreamTest03 {

    public static void main(String... args) {
//        test01();
//        test02();
        test03();
    }

    // 累加
    private static void test01() {
        List<Integer> nums = Arrays.asList(4, 5, 3, 9);
        Integer reduce = nums.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    // 求最大值
    private static void test02() {
        List<Integer> integers = Arrays.asList(66, 34, 58, 99, 88);
        Integer reduce = integers.stream().reduce(0, Math::max);  // Integer::max
        System.out.println(reduce);
    }

    // 求有多少种菜
    private static void test03() {
//        Integer reduce = menu.stream().map(dish -> 1).reduce(0, Integer::sum);
        long reduce = menu.stream().count();

        System.out.println(reduce);
    }

}
