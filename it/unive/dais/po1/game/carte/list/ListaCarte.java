package it.unive.dais.po1.game.carte.list;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.Figura;
import it.unive.dais.po1.game.carte.Seme;

import java.lang.reflect.Array;
import java.util.Stack;

public class ListaCarte<C extends Card> {
    protected final Stack<C> carte;

    protected ListaCarte() {
        this.carte = new Stack<>();
    }

    protected C getFirstCard() {
        return this.carte.pop();
    }

    protected void addCard(C card) {
        this.carte.push(card);
    }

}
