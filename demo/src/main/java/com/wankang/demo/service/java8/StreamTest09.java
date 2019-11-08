package com.wankang.demo.service.java8;

import com.wankang.demo.dto.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.wankang.demo.dto.Dish.menu;

/**
 * 分区 partitioningBy (根据Boolean类型值分组)
 *
 * @author wankang
 * @create 2019-07-16 20:19
 **/
public class StreamTest09 {

    public static void main(String... args) {
//        test01();
//        test02();
//        test03();
//        test04();
//        new BigDecimal("999999999999999999999999999999999999.99");

        List<String> list = new ArrayList<>();
        if( list != null  && !list.isEmpty()) {
            System.out.println("1");
        } else {
            System.out.println("2");
        }

    }

    // 区分素食与荤食
    private static void test01() {
        Map<Boolean, List<Dish>> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(collect);
    }

    // 再分别对荤食与素食分组
    private static void test02() {
        Map<Boolean, Map<Dish.Type, List<Dish>>> collect =
                menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
        System.out.println(collect);
    }

    // 分别找出荤食与素食中热量最高的菜
    private static void test03() {
        Map<Boolean, Dish> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian,
                Collectors.collectingAndThen(  // 处理Optional
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get
                )
        ));
        System.out.println(collect);
    }

    // 判断是否为质数
    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    // 将数字按质数和非质数分区
    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(
                        Collectors.partitioningBy(candidate -> isPrime(candidate)));
    }

    private static void test04() {
        Map<Boolean, List<Integer>> booleanListMap = partitionPrimes(7);
        System.out.println(booleanListMap);
    }


}
