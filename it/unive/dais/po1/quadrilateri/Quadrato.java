package it.unive.dais.po1.quadrilateri;

final public class Quadrato extends Quadrilatero {

    public Quadrato(int lato) {
        super(lato, lato, lato, lato);
    }

    @Override
    public int getArea() {
        return this.getLato()*this.getLato();
    }
}
