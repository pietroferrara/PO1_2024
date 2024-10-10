package it.unive.dais.po1.game.giocatori;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.gioco.Briscola;

/**
 * Una classe che rappresenta un giocatore
 * @author Pietro Ferrara
 * @version 2.0
 * @since 1.2
 */
public abstract class Giocatore {

    private static int numberOfPlayers = 0;

    /**
     * Le (massimo) tre carte che il giocatore ha in mano
     */
    protected Card[] carte = new Card[3];

    /**
     * Le carte vinte dal giocatore durante la partita
     */
    private Card[] carteVinte = new Card[40];

    public String getName() {
        return name;
    }

    private final String name;

    public Giocatore(String name) {
        this.name = name;
        Giocatore.incrementPlayers();
    }

    final static public void incrementPlayers() {
        numberOfPlayers++;
    }


    final protected Card getFirstCard() {
        for(int i = 0; i < 3; i++) {
            if(carte[i] != null) {
                Card result = carte[i];
                carte[i] = null;
                return result;
            }
        }
        return null;
    }

    /**
     * Riceve la carta passata come parametro
     * @param pop la carta presa dal mazzo
     * @return true se la carta viene presa correttamente
     */
    public boolean giveCard(Card pop) {
        if(carte[0] == null) {
            carte[0] = pop;
            return true;
        }
        else if(carte[1] == null) {
            carte[1] = pop;
            return true;
        }
        else if(carte[2] == null) {
            carte[2] = pop;
            return true;
        }
        else return false;
    }


    /**
     * Ritorna una carta e la elimina tra quelle che ha nel mazzo
     * @return la carta scartata
     */
     abstract public Card getCard(Card otherCard, Briscola game);

    /**
     * Raccoglie le due carte dal tavolo e le mette tra le carte vinte
     * @param prima la prima carta sul tavolo
     * @param seconda la seconda carta sul tavolo
     */
    final public void takeCards(Card prima, Card seconda) {
        int i = 0;
        while(carteVinte[i] != null)
            i++;
        carteVinte[i++] = prima;
        carteVinte[i] = seconda;
    }

    /**
     * Ritorna tutte le carte vinte
     * @return le carte vinte
     */
    final public Card[] getCarteVinte() {
        return this.carteVinte;
    }

    final public void dropAllCards() {
        carte = new Card[3];
        carteVinte = new Card[40];
    }
}
