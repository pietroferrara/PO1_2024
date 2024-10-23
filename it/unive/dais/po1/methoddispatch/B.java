package it.unive.dais.po1.methoddispatch;

public class B extends A {
    @Override
    void foo(int i) {
        System.out.println("B.int");
    }

    @Override B foo12(A a) {
        System.out.println("foo12");
        return this;
    }


    static void foo2() {
        System.out.println("B static .foo2()");
    }
}
