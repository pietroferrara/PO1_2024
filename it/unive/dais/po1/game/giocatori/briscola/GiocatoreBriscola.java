package it.unive.dais.po1.game.giocatori.briscola;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.francesi.FiguraFrancese;
import it.unive.dais.po1.game.carte.list.CarteATerra;
import it.unive.dais.po1.game.carte.list.CarteInMano;
import it.unive.dais.po1.game.carte.list.CarteRaccolte;
import it.unive.dais.po1.game.carte.trevigiane.FiguraTrevigiana;
import it.unive.dais.po1.game.carte.trevigiane.SemeTrevigiano;
import it.unive.dais.po1.game.gioco.briscola.Briscola;

/**
 * Una classe che rappresenta un giocatore
 * @author Pietro Ferrara
 * @version 2.0
 * @since 1.2
 */
public abstract class GiocatoreBriscola {

    private static int numberOfPlayers = 0;

    /**
     * Le (massimo) tre carte che il giocatore ha in mano
     */
    protected CarteInMano<Card<SemeTrevigiano, FiguraTrevigiana>> carte = new CarteInMano<>(3);

    /**
     * Le carte vinte dal giocatore durante la partita
     */
    private CarteRaccolte<Card<SemeTrevigiano, FiguraTrevigiana>> carteVinte = new CarteRaccolte<>(40);

    public String getName() {
        return name;
    }

    private final String name;

    public GiocatoreBriscola(String name) {
        this.name = name;
        GiocatoreBriscola.incrementPlayers();
    }

    final static public void incrementPlayers() {
        numberOfPlayers++;
    }


    final protected Card<SemeTrevigiano, FiguraTrevigiana> getFirstCard() {
        return carte.getCard();
    }

    /**
     * Riceve la carta passata come parametro
     * @param pop la carta presa dal mazzo
     * @return true se la carta viene presa correttamente
     */
    public boolean giveCard(Card<SemeTrevigiano, FiguraTrevigiana> pop) {
        return carte.add(pop);
    }


    /**
     * Ritorna una carta e la elimina tra quelle che ha nel mazzo
     * @return la carta scartata
     */
     abstract public Card<SemeTrevigiano, FiguraTrevigiana> getCard(CarteATerra<Card<SemeTrevigiano, FiguraTrevigiana>> otherCard, Briscola game);

    /**
     * Raccoglie le due carte dal tavolo e le mette tra le carte vinte
     * @param prima la prima carta sul tavolo
     * @param seconda la seconda carta sul tavolo
     */
    final public void takeCards(CarteATerra<Card<SemeTrevigiano, FiguraFrancese>> carte) {
        for(int i = 0; i < carte.count(); i++)
            carteVinte.add(carte.get(i));
    }

    /**
     * Ritorna tutte le carte vinte
     * @return le carte vinte
     */
    final public CarteRaccolte<Card<SemeTrevigiano, FiguraTrevigiana>> getCarteVinte() {
        return this.carteVinte;
    }

    final public void dropAllCards(int carteInMano, int carteVinte) {
        this.carte = new CarteInMano<>(carteInMano);
        this.carteVinte = new CarteRaccolte<>(carteVinte);
    }
}
