package it.unive.dais.po1.quadrilateri;

public class Trapezio extends Quadrilatero {
    private final int baseMin, baseMax, altezza, lato1, lato2;

    public Trapezio(int baseMin, int baseMax, int altezza, int lato1, int lato2) {
        super(baseMin, baseMax, lato1, lato2);
        this.baseMin = baseMin;
        this.baseMax = baseMax;
        this.altezza = altezza;
        this.lato1 = lato1;
        this.lato2 = lato2;
    }

    @Override
    public int getArea() {
        return (this.baseMin+this.baseMax)*this.altezza/2;
    }
}
