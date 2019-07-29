package com.wankang.demo.service.java8;

/**
 * default 方法显式声明调用
 * 两个默认方法都同样具体时，你需要在类中覆盖该方法，显式地选择使用哪个接口中提供的默认方法。
 *
 * @author wankang
 * @create 2019-07-25 16:49
 **/
public class DefaultMethodTest02 {

    public static void main(String... args) {
        new C().hello();
    }

    static interface A {
        public default void hello() {
            System.out.println("Hello from A");
        }
    }

    static interface B {
        public default void hello() {
            System.out.println("Hello from B");
        }
    }

    static class C implements B, A {
        public void hello() {
            A.super.hello();  // 必须显示声明调用哪个方法
        }
    }

}
