package it.unive.dais.po1.game.carte;

public class CarteATerra extends ListaCarte {
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

    public void add(Card c) {
        super.addCard(c);
    }
}
