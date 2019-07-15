package com.wankang.demo.service.java8;

import com.wankang.demo.dto.Apple;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * ${DESCRIPTION}
 *
 * @author wankang
 * @create 2019-07-13 11:28
 **/
public class LambdaTest01 {

    public static void main(String[] args) {
//        test01();
        test02();

    }

    private static void test01() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(34);

        list.sort(Integer::compareTo);

        System.out.print(list);
    }

    private static void test02() {
        ArrayList<Apple> list = new ArrayList<>();
        list.add(new Apple(5,"圆形"));
        list.add(new Apple(3,"正方形"));
        list.add(new Apple(3,"长方形"));
        list.add(new Apple(8,"椭圆形"));

        list.sort(Comparator.comparingInt(Apple::getWeight).reversed().thenComparing(Apple::getShape));  // 逆序
//        list.stream().sorted(Comparator.comparing(Apple::getWeight)); 不一样

        System.out.print(list);
    }

    // 对局部变量的限制
    private static  void test03(){
        int num = 12;
        Runnable r = () -> System.out.print(num); //num++
//        num = 13;
    }

}
