package it.unive.dais.po1.game.giocatori;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.CarteATerra;
import it.unive.dais.po1.game.carte.CarteInMano;
import it.unive.dais.po1.game.carte.CarteRaccolte;
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
    protected CarteInMano carte = new CarteInMano(3);

    /**
     * Le carte vinte dal giocatore durante la partita
     */
    private CarteRaccolte carteVinte = new CarteRaccolte(40);

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
        return carte.getCard();
    }

    /**
     * Riceve la carta passata come parametro
     * @param pop la carta presa dal mazzo
     * @return true se la carta viene presa correttamente
     */
    public boolean giveCard(Card pop) {
        return carte.add(pop);
    }


    /**
     * Ritorna una carta e la elimina tra quelle che ha nel mazzo
     * @return la carta scartata
     */
     abstract public Card getCard(CarteATerra otherCard, Briscola game);

    /**
     * Raccoglie le due carte dal tavolo e le mette tra le carte vinte
     * @param prima la prima carta sul tavolo
     * @param seconda la seconda carta sul tavolo
     */
    final public void takeCards(CarteATerra carte) {
        for(int i = 0; i < carte.count(); i++)
            carteVinte.add(carte.get(i));
    }

    /**
     * Ritorna tutte le carte vinte
     * @return le carte vinte
     */
    final public CarteRaccolte getCarteVinte() {
        return this.carteVinte;
    }

    final public void dropAllCards(int carteInMano, int carteVinte) {
        this.carte = new CarteInMano(carteInMano);
        this.carteVinte = new CarteRaccolte(carteVinte);
    }
}
