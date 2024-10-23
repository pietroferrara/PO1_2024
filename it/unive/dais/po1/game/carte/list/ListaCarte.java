package it.unive.dais.po1.game.carte.list;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.Figura;
import it.unive.dais.po1.game.carte.Seme;

import java.lang.reflect.Array;

public class ListaCarte<C extends Card> {
    protected final C[] carte;

    protected ListaCarte(int length) {
        this.carte =
                (C[]) Array.newInstance(C, length);
    }

    protected C getFirstCard() {
        C temp = carte[0];
        for(int i = 1; i < carte.length; i++) {
            carte[i-1]=carte[i];
        }
        carte[carte.length-1] = null;
        return temp;
    }

    protected boolean addCard(C card) {
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
