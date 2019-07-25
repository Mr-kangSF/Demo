package com.wankang.demo.service.java8;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * peek 测试
 * 流提供的peek方法在分析Stream流水线时，能将中间变量的值输出到日志中，是非常有用的工具
 *
 * @author wankang
 * @create 2019-07-25 11:40
 **/
public class StreamTest10 {

    // 使用peek查看Stream流水线中的数据流的值
    public static void main(String... args) {
        List<Integer> result = Stream.of(2, 3, 4, 5)
                .peek(x -> System.out.println("taking from stream: " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map: " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter: " + x))
                .limit(3)
                .peek(x -> System.out.println("after limit: " + x))
                .collect(toList());

        System.out.println(result);
    }


}
