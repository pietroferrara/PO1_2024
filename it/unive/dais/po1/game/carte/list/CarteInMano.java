package it.unive.dais.po1.game.carte.list;

import it.unive.dais.po1.game.carte.Card;

public class CarteInMano extends ListaCarte implements Addable, Countable, Readable {
    public CarteInMano(int length) {
        super(length);
    }

    public Card getCard() {
        return super.getFirstCard();
    }


    public boolean add(Card c) {
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
