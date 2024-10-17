package it.unive.dais.po1.game.carte;

public class CarteRaccolte extends ListaCarte implements Addable, Readable, AvailableSpots {
    public CarteRaccolte(int length) {
        super(length);
    }

    public boolean add(Card c) {
        return super.addCard(c);
    }

    public Card get(int index) {
        return carte[index];
    }

    public boolean acceptMoreItems() {
        return carte[carte.length-1]==null;
    }
}
