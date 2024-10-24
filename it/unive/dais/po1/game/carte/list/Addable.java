package it.unive.dais.po1.game.carte.list;

import it.unive.dais.po1.game.carte.Card;

public interface Addable<C extends Card> {
    public boolean add(C c);

}
