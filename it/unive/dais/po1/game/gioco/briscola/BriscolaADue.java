package it.unive.dais.po1.game.gioco.briscola;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.list.CarteATerra;
import it.unive.dais.po1.game.carte.list.MissingCardException;
import it.unive.dais.po1.game.giocatori.briscola.GiocatoreBriscola;

public class BriscolaADue extends Briscola {

    private GiocatoreBriscola g1, g2;

    public BriscolaADue(GiocatoreBriscola g1, GiocatoreBriscola g2) {
        this.g1 = g1;
        this.g2 = g2;
    }


    /**
     * @requires g1!=null && g2!=null && g1!=g2 //precondizione
     * @ensures return==g1 || return==g2 || return==null
     */
    public GiocatoreBriscola partita() throws MissingCardException {
        //controllare che g1!=null && g2!=null && g1!=g2
        //@invariant mazzo.mazzo!=null
        //@invariant mazzo.cartaCorrente>=0 mazzo.cartaCorrente<mazzo.mazzo.length
        //@requires \forall i >= 0 && i < mazzo.length : mazzo[i]!=null
        mazzo.shuffle();
        super.getInitialCards(g1);
        super.getInitialCards(g2);

        briscola = mazzo.pop();
        GiocatoreBriscola primoDiMano = g1;
        GiocatoreBriscola secondoDiMano = g2;
        boolean mazzoIsEmpty = false;
        while(! mazzoIsEmpty) {
            GiocatoreBriscola vincitore = giocaMano(primoDiMano, secondoDiMano);
            if(vincitore == secondoDiMano) {
                GiocatoreBriscola temp = primoDiMano;
                primoDiMano = secondoDiMano;
                secondoDiMano = temp;
            }
            primoDiMano.giveCard(mazzo.pop());
            if(mazzo.isEmpty()) {
                mazzoIsEmpty = true;
                secondoDiMano.giveCard(briscola);
            }
            else secondoDiMano.giveCard(mazzo.pop());
        }
        for(int i = 0; i < 3; i++) {
            GiocatoreBriscola vincitore = giocaMano(primoDiMano, secondoDiMano);
            if(vincitore == secondoDiMano) {
                GiocatoreBriscola temp = primoDiMano;
                primoDiMano = secondoDiMano;
                secondoDiMano = temp;
            }
        }
        int punteggiog1 = contaPunti(g1.getCarteVinte());
        int punteggiog2 = contaPunti(g2.getCarteVinte());
        g1.dropAllCards();
        g2.dropAllCards();
        if(punteggiog1 > punteggiog2)
            return g1;
        else if(punteggiog1 < punteggiog2)
            return g2;
        else return null;
        //return g1||g2||null
    }

    public GiocatoreBriscola getLastPlayer() {
        return g2;
    }

    public boolean prende(int i, int j) {
        return false;
    }

    private GiocatoreBriscola giocaMano(GiocatoreBriscola primoDiMano, GiocatoreBriscola secondoDiMano) throws MissingCardException {
        CarteATerra c = new CarteATerra();
        Card prima = primoDiMano.getCard(c, this);
        c.add(prima);
        Card seconda = secondoDiMano.getCard(c, this);
        c.add(seconda);
        if(maggiore(prima, seconda)) {
            primoDiMano.takeCards(c);
            return primoDiMano;
        }
        else {
            secondoDiMano.takeCards(c);
            return secondoDiMano;
        }

    }
}
