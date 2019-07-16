package com.wankang.demo.service.java8;

import com.wankang.demo.dto.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static com.wankang.demo.dto.Dish.menu;
//import static java.util.stream.Collectors.*;

/**
 * 分组
 *
 * @author wankang
 * @create 2019-07-16 9:39
 **/
public class StreamTest08 {

    public enum CaloricLevel {DIET, NORMAL, FAT}   // 节食 正常  偏肥

    public static void main(String[] args) {
//        test01();
//        test02();
//        test03();
//        test04();
//        test05();
//        test06();
        test07();

    }

    // joining
    private static void test01() {
        String collect = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(collect);
    }

    // 对食物按卡路里分组
    private static void test02() {
        Map<CaloricLevel, List<Dish>> collect = menu.stream().collect(
                Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                })
        );

        System.out.println(collect);
    }

    // 多级分组
    private static void test03() {
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> collect = menu.stream().collect(
                Collectors.groupingBy(Dish::getType,     // 一级分组
                        Collectors.groupingBy(dish -> {    // 二级分组
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 600) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        }))
        );
        System.out.println(collect);
    }

    // 分组计数
    private static void test04() {
        Map<Dish.Type, Long> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(collect);
    }

    // 选出各个类型中热量最高的Dish
    private static void test05() {
        Map<Dish.Type, Optional<Dish>> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparing(Dish::getCalories))));
        System.out.println(collect);
    }

    // 选出各个类型中热量最高的Dish (优化,去除Optional)
    private static void test06() {
        Map<Dish.Type, Dish> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Dish::getCalories)), Optional::get
                )
        ));

        System.out.println(collect);
    }

    // 对于每种类型的Dish，菜单中都有哪些CaloricLevel
    private static void test07() {
        Map<Dish.Type, Set<CaloricLevel>> collect = menu.stream().collect(
                Collectors.groupingBy(Dish::getType, Collectors.mapping(
                        dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 680) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        }, Collectors.toCollection(HashSet::new) // Collectors.toSet()     可以指定返回set类型
                ))
        );
        System.out.println(collect);
    }


}
