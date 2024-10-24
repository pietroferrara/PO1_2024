package it.unive.dais.po1.game.carte.list;

import it.unive.dais.po1.game.carte.Card;

public class CarteATerra<C extends Card> extends ListaCarte<C> implements Addable<C>, Countable, Readable {
    public CarteATerra(int length) {
        super(length);
    }


    public boolean add(C c) {
        return super.addCard(c);
    }

    public int count() {
        int i = 0;
        while(i < carte.length && carte[i]!=null)
            i++;
        return i;
    }

    public Card get(int index) {
        return carte[index];
    }
}
