package it.unive.dais.po1.game.carte.list;

import it.unive.dais.po1.game.carte.Card;

public class CarteRaccolte<C extends Card> extends ListaCarte<C> implements Addable<C>, Readable, AvailableSpots {
    public void add(C c) {
        super.addCard(c);
    }

    public Card get(int index) {
        return carte.get(index);
    }

    public int size() {
        return carte.size();
    }

    public boolean acceptMoreItems() {
        return true;
    }
}
