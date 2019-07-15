package com.wankang.demo.service.java8;

import java.util.stream.Stream;

/**
 * 无限流
 *
 * @author wankang
 * @create 2019-07-15 16:35
 **/
public class StreamTest06 {

    public static void main(String... args) {
//        test01();
//        test02();
        test03();
    }

    // 连续打印10个偶数
    private static void test01() {
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }

    // 斐波那契数列（0，1，1，2，3，5，8，13，。。。。）
    private static  void test02() {
        Stream.iterate(new int[]{0,1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    // generate
    private static void test03() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }


}
