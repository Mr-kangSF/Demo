package com.wankang.demo.service.java8;

import com.wankang.demo.dto.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.wankang.demo.dto.Dish.menu;

/**
 * ${DESCRIPTION}
 *
 * @author wankang
 * @create 2019-07-15 23:28
 **/
public class StreamTest07 {

    public static void main(String... args){
//        test01();
//        test02();
//        test03();
        test04();
    }

    // maxBy  minBy
    private static void test01() {
        Optional<Dish> collect = menu.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
//                .sorted(Comparator.comparing(Dish::getCalories).reversed()).findFirst();
        if (collect.isPresent()) {
            System.out.println(collect.get().getCalories());
        }
    }

    // summingInt
    private  static void test02() {
        Integer collect = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(collect);
    }

    // averagingInt
    private  static void test03() {
        Double collect = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(collect);
    }

    // summarizingInt工厂，一次返回总数，最大最小值，求和，平均数
    private static void test04() {
        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(collect);
    }

}
