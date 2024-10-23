package it.unive.dais.po1.game.giocatori;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.list.CarteATerra;
import it.unive.dais.po1.game.gioco.Briscola;

/**
 * Una classe che rappresenta un giocatore
 * @author Pietro Ferrara
 * @version 2.0
 * @since 1.2
 */
final public class GiocatoreNaive extends Giocatore {
    public GiocatoreNaive(String name) {
        super(name);
    }

    /**
     * Ritorna una carta e la elimina tra quelle che ha nel mazzo
     * @return la carta scartata
     */
    @Override public Card getCard(CarteATerra otherCard, Briscola game) {
        return super.getFirstCard();
    }




}
