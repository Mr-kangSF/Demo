package com.wankang.demo.controller;

import java.util.stream.Stream;

/**
 * ${DESCRIPTION}
 *
 * @author wankang
 * @create 2019-07-02 10:40
 **/
public class TestController {
    public static void main(String[] args) throws Exception{
        Stream<String> stream= Stream.of("I", "love", "you", "too");
        stream.sorted((str1, str2) -> str1.length()-str2.length())
                .forEach(str -> System.out.println(str));

    }




}
