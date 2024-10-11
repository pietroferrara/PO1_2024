package it.unive.dais.po1.game.carte;

public class CarteInMano extends ListaCarte {
    public CarteInMano(int length) {
        super(length);
    }

    public Card getCard() {
        return super.getFirstCard();
    }

    public boolean receiveCard(Card c) {
        if(carte[0]!=null && carte[1]!=null && carte[2]!=null)
            return false;
        super.addCard(c);
        return true;
    }


    public int contaCarteInMano() {
        int i = 0;
        while(i < carte.length && carte[i]!=null)
            i++;
        return i;
    }

    public Card see(int index) {
        return carte[index];
    }
}
