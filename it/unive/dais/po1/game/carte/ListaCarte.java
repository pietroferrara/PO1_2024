package it.unive.dais.po1.game.carte;

class ListaCarte {
    protected final Card[] carte;

    protected ListaCarte(int length) {
        this.carte = new Card[length];
    }

    protected Card getFirstCard() {
        Card temp = carte[0];
        for(int i = 1; i < carte.length; i++) {
            carte[i-1]=carte[i];
        }
        carte[carte.length-1] = null;
        return temp;
    }

    protected boolean addCard(Card card) {
        if(carte[carte.length-1]!=null) {
            return false;
        }
        for(int i = carte.length-1; i > 0; i--) {
            carte[i]=carte[i-1];
        }
        carte[0] = card;
        return true;
    }

}
