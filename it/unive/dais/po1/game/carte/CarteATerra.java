package it.unive.dais.po1.game.carte;

public class CarteATerra extends ListaCarte implements Addable {
    public CarteATerra(int length) {
        super(length);
    }

    public int contaCarteATerra() {
        int i = 0;
        while(i < carte.length && carte[i]!=null)
            i++;
        return i;
    }

    public Card seeCard(int i) {
        return carte[i];
    }

    public boolean add(Card c) {
        super.addCard(c);
        return true;
    }
}
