package it.unive.dais.po1.game.carte.list;

import it.unive.dais.po1.game.carte.Card;

public class CarteInMano<C extends Card> extends ListaCarte<C> implements Addable<C>, Countable, Readable {


    public Card getCard() throws MissingCardException {
        return super.getFirstCard();
    }


    public void add(C c) {
        super.addCard(c);
    }

    public int count() {
        return this.carte.size();
    }

    public Card get(int index) {
        return carte.get(index);
    }
}
