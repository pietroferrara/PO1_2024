package it.unive.dais.po1.methoddispatch;

public class A {


    void foo2(A a1, A a2) {
        System.out.println("A.foo2(A, A)");
    }


    void foo2(A a1, B a2) {
        System.out.println("A.foo2(A, B)");
    }

    static void foo2() {
        System.out.println("A static .foo2()");
    }

    void foo2(B a1, A a2) {
        System.out.println("A.foo2(B, A)");
    }



    /*void foo2(B a1, B a2) {
        System.out.println("A.foo2(B, B)");
    }*/

    void foo(A i) {
        System.out.println("A.A");
    }

    void foo(B i) {
        System.out.println("A.B");
    }

    void foo(int i) {
        System.out.println("A.int");
    }

    void foo(double d) {
        System.out.println("A.double");
    }
}
