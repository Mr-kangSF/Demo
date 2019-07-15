package com.wankang.demo.service.java8;

import com.wankang.demo.dto.Dish;

import static com.wankang.demo.dto.Dish.menu;

/**
 * ${DESCRIPTION}
 *
 * @author wankang
 * @create 2019-07-14 18:21
 **/
public class StreamTest02 {

    public static void main(String[] args) {
//        test01();
//        test02();
        test03();
    }

    // anyMatch
    private static void test01() {
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.print("有肉吃");
        }
    }

    // allMatch  noneMatchs
    private static void test02() {
//        boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        boolean isHealthy = menu.stream().noneMatch(dish -> dish.getCalories() >= 1000);
        if (isHealthy) {
            System.out.println("都是健康食物");
        }
    }

    // findAny   findFirst
    private static void test03() {
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println(dish.getName()));   // 注意isPresent() 和ifPresent(Consumer<T> block) 的区别
    }


}
