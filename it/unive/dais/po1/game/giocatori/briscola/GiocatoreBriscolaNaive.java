package it.unive.dais.po1.game.giocatori.briscola;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.list.CarteATerra;
import it.unive.dais.po1.game.carte.trevigiane.FiguraTrevigiana;
import it.unive.dais.po1.game.carte.trevigiane.SemeTrevigiano;
import it.unive.dais.po1.game.gioco.briscola.Briscola;

/**
 * Una classe che rappresenta un giocatore
 * @author Pietro Ferrara
 * @version 2.0
 * @since 1.2
 */
final public class GiocatoreBriscolaNaive extends GiocatoreBriscola {
    public GiocatoreBriscolaNaive(String name) {
        super(name);
    }

    /**
     * Ritorna una carta e la elimina tra quelle che ha nel mazzo
     * @return la carta scartata
     */
    @Override public Card<SemeTrevigiano, FiguraTrevigiana> getCard(CarteATerra<Card<SemeTrevigiano, FiguraTrevigiana>> otherCard, Briscola game) {
        return super.getFirstCard();
    }




}
