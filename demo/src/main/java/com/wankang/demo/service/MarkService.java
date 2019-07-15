package com.wankang.demo.service;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * ${DESCRIPTION}
 *
 * @author wankang
 * @create 2019-07-12 11:41
 **/
public class MarkService {

    public static void main(String[] args) throws Exception {
        // https://segmentfault.com/n/1330000019739227   java反射知识点
        Set s = new HashSet();
        s.add("foo");
        Iterator i = s.iterator();
        Method m = i.getClass().getMethod("hasNext", new Class[0]);
        m.setAccessible(true);
        System.out.println(m.invoke(i, new Object[0]));
    }


}
