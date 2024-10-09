package it.unive.dais.po1.game.giocatori;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.gioco.Briscola;

/**
 * Una classe che rappresenta un giocatore
 * @author Pietro Ferrara
 * @version 2.0
 * @since 1.2
 */
public class GiocatoreNaive extends Giocatore {
    public GiocatoreNaive(String name) {
        super(name);
    }

    /**
     * Ritorna una carta e la elimina tra quelle che ha nel mazzo
     * @return la carta scartata
     */
    public Card getCard(Card otherCard, Briscola game) {
        for(int i = 0; i < 3; i++) {
            if(carte[i] != null) {
                Card result = carte[i];
                carte[i] = null;
                return result;
            }
        }
        return null;
    }

 }
