package it.unive.dais.po1.quadrilateri;

abstract public class Quadrilatero {
    private final int lato1, lato2, lato3, lato4;

    protected Quadrilatero(int lato1, int lato2, int lato3, int lato4) {
        this.lato1 = lato1;
        this.lato2 = lato2;
        this.lato3 = lato3;
        this.lato4 = lato4;
    }

    public int getPerimetro() {
        return lato1 + lato2 + lato3 + lato4;
    }
    abstract public int getArea();

    protected int getLato() {
        return lato1;
    }
}
