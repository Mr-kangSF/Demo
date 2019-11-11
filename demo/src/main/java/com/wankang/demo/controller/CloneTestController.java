package com.wankang.demo.controller;

import com.wankang.demo.dto.clone.Car;
import com.wankang.demo.dto.clone.Person;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 使用序列化实现深度克隆---------原型设计模式
 *
 * @author wankang
 * @create 2019-11-08 15:56
 **/
@Slf4j
public class CloneTestController {

    /**
     * 深度克隆
     * @param args
     */
    public static void main(String... args){
        // 原型对象
        Person person = new Person();
        person.setAge(10);
        person.setSex("man");
        Car car = new Car();
        car.setColor("red");
        car.setWeight(10000);
        person.setCar(car);


        // 开始克隆
        try {
            Person newPerson = person.deepClone();

            // 比较person
            System.out.println("person是否相同：" + (person == newPerson));

            // 比较car
            System.out.println("car是否相同：" + (person.getCar() == newPerson.getCar()));

        } catch (IOException e) {
            log.error("克隆失败，io异常");
        } catch (ClassNotFoundException e) {
            log.error("克隆失败, ClassNotFoundException");
        }


    }




}
