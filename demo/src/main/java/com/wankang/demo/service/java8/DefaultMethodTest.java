package com.wankang.demo.service.java8;

/**
 *
 *
 * @author wankang
 * @create 2019-07-25 16:42
 **/
public class DefaultMethodTest {

    public static void main(String... args) {
//        new C().hello();
//        new E().hello();
        new G().hello();
    }

    static interface A {
        public default void hello() {
            System.out.println("Hello from A");
        }
    }

    static interface B extends A {
        public default void hello() {
            System.out.println("Hello from B");
        }
    }

    static class C implements B, A {
    }

    static class D implements A {
    }

    static class E extends D implements B, A {
    }

    static class F implements B, A {
        public void hello() {
            System.out.println("Hello from F");
        }
    }

    static class G extends F implements B, A {
    }
}
