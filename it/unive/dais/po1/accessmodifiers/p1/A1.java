package it.unive.dais.po1.accessmodifiers.p1;

import it.unive.dais.po1.accessmodifiers.p2.B;

public class A1 {
    public int pbl;
    int pckg;
    private int pvt;

    void foo(A1 other_a1, A2 a2, B b) {
        int x = this.pvt;
        x = this.pckg;
        x = this.pbl;
        x = other_a1.pvt;
        x = other_a1.pckg;
        x = other_a1.pbl;
        //x = a2.pvt; NOT ALLOWED
        x = a2.pckg;
        x = a2.pbl;
        //x = b.pvt; NOT ALLOWED
        //x = b.pckg; NOT ALLOWED
        x = b.pbl;
    }
}
