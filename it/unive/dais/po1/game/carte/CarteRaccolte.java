package it.unive.dais.po1.game.carte;

public class CarteRaccolte extends ListaCarte {
    public CarteRaccolte(int length) {
        super(length);
    }

    public void add(Card c) {
        super.addCard(c);
    }

    public Card getCard(int index) {
        return carte[index];
    }
}
