package it.unive.dais.po1.methoddispatch;

public class Test {
    public static void main(String[] args) {
        //A.foo2();
        //B.foo2();


        A a = new A();
        A a2 = new A();
        A a3 = new B();
        B b = new B();

        //a.foo2();
        //b.foo2();
        a3.foo2();

        /*a.foo2(a2, a2);
        //a.foo2(b, b);
        a.foo2(a2, b);
        a.foo2(a3, b);
*/
        /*a.foo(a2); //A.A
        a.foo(a3);
        a.foo((B) a3);//A.A se binding statico sul tipo dei parametri
        //A.A se binding dinamico sul tipo dei parametri
        // a3 tipo statico A, tipo dinamico B
        a.foo(b);//A.B
        ((A) b).foo(10);*/
    }
}
