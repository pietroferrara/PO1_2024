package it.unive.dais.po1.game.carte;

public interface Figura<F extends Figura<F>> extends Comparable<F> {

    @Deprecated(forRemoval = true, since="lect. 22") int getValue();
    boolean isErrata();
}
