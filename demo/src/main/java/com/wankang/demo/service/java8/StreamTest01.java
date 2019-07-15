package com.wankang.demo.service.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ${DESCRIPTION}
 *
 * @author wankang
 * @create 2019-07-14 17:28
 **/
public class StreamTest01 {

    public static void main(String... args) {
        test01();
    }

    // map与flatMap (java8实战P87---流的扁平化)
    private static void test01() {
        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> list = words.stream()
                .map(word -> word.split(""))  // 其实是数组
                .distinct()
                .collect(Collectors.toList());

        System.out.print(list);
    }

    private static  void test02(){
        String[] str = {"Goodbye", "World"};
        Stream<String> stream = Arrays.stream(str);
    }

    // 还是不行
    private static  void test03(){
        List<String> words = Arrays.asList("Hello", "World");
        List<Stream<String>> list = words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

    }

    // 终于可以了
    private static  void test04(){
        List<String> words = Arrays.asList("Hello", "World");
        List<String> list = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.print(list);
    }





    private static void test() {
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLengths);

        // flatMap
        words.stream()
                .flatMap((line) -> Arrays.stream(line.split("")))
                .distinct()
                .forEach(System.out::println);
    }

}
