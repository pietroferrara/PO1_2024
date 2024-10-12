package it.unive.dais.po1.quadrilateri;

public class Rectangle extends Quadrilatero {
    int base, altezza;

    public Rectangle(int base, int altezza) {
        super(base, base, altezza, altezza);
        this.base=base;
        this.altezza=altezza;
    }


    @Override
    public int getArea() {
        return base*altezza;
    }
}
