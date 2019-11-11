package com.wankang.demo.controller;

import com.wankang.demo.dto.clone.Person;

import java.io.IOException;

/**
 * ${DESCRIPTION}
 *
 * @author wankang
 * @create 2019-11-11 0:51
 **/
public class ProtoTypeController {

    public static void main(String... args) throws IOException, ClassNotFoundException {
        test01(100);
        test02(100);
    }

    private static void test01(int size) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Person obj = new Person();
        }
        long end = System.currentTimeMillis();
        System.out.println("new的方式创建对象耗时：" + (end - begin));
    }

    private static void test02(int size) throws IOException, ClassNotFoundException {
        long begin = System.currentTimeMillis();
        Person obj = new Person();
        for (int i = 0; i < size; i++) {
            Person obj1 = (Person) obj.deepClone();
        }
        long end = System.currentTimeMillis();
        System.out.println("序列化克隆的方式创建对象耗时：" + (end - begin));
    }


}
