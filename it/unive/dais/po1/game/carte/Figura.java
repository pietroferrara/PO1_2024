package it.unive.dais.po1.game.carte;

public interface Figura<F extends Figura<F>> extends Comparable<F> {

    int getValue();
    boolean isErrata();
}
