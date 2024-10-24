package it.unive.dais.po1.game.carte.list;

import it.unive.dais.po1.game.carte.Card;

public class CarteRaccolte<C extends Card> extends ListaCarte<C> implements Addable<C>, Readable, AvailableSpots {
    public CarteRaccolte(int length) {
        super(length);
    }

    public boolean add(C c) {
        return super.addCard(c);
    }

    public Card get(int index) {
        return carte[index];
    }

    public boolean acceptMoreItems() {
        return carte[carte.length-1]==null;
    }
}
