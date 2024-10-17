package it.unive.dais.po1.game.carte;

public class CarteATerra extends ListaCarte implements Addable, Countable, Readable {
    public CarteATerra(int length) {
        super(length);
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
