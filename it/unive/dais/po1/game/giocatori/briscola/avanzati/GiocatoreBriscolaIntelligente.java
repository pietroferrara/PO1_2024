package it.unive.dais.po1.game.giocatori.briscola.avanzati;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.list.CarteATerra;
import it.unive.dais.po1.game.carte.trevigiane.FiguraTrevigiana;
import it.unive.dais.po1.game.carte.trevigiane.SemeTrevigiano;
import it.unive.dais.po1.game.giocatori.briscola.GiocatoreBriscola;
import it.unive.dais.po1.game.gioco.briscola.Briscola;

/**
 * Una classe che rappresenta un giocatore
 * @author Pietro Ferrara
 * @version 2.0
 * @since 1.2
 */
public class GiocatoreBriscolaIntelligente extends GiocatoreBriscola {

    public GiocatoreBriscolaIntelligente(String name) {
        super(name);
    }

    /**
     * Ritorna una carta e la elimina tra quelle che ha nel mazzo
     * @return la carta scartata
     */
    @Override public Card<SemeTrevigiano, FiguraTrevigiana> getCard(CarteATerra<Card<SemeTrevigiano, FiguraTrevigiana>> carteATerra, Briscola game) {
        if(carteATerra.count() == 1) {
            Card otherCard = carteATerra.get(0);
            for (int i = 0; i < carte.count(); i++) {
                Card currentCard = carte.get(i);
                if (currentCard != null && game.maggiore(currentCard, otherCard)) {
                    return carte.getCard();
                }
            }
        }
        return super.getFirstCard();
    }



}
