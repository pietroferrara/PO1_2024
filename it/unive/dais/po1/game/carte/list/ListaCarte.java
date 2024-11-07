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

    /**
     *
     * @return the card at the top of the list
     * @throws MissingCardException if the card list does not contain any card
     */
    protected C getFirstCard() throws MissingCardException {
        if(this.carte.isEmpty()) {
            throw new MissingCardException("The set of cards does not contain any element");
        }
        return this.carte.pop();
    }

    protected void addCard(C card) {
        this.carte.push(card);
    }

}
