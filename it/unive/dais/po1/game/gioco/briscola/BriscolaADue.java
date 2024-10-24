package it.unive.dais.po1.game.gioco.briscola;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.list.CarteATerra;
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
    public GiocatoreBriscola partita() {
        //controllare che g1!=null && g2!=null && g1!=g2
        //@invariant mazzo.mazzo!=null
        //@invariant mazzo.cartaCorrente>=0 mazzo.cartaCorrente<mazzo.mazzo.length
        //@requires \forall i >= 0 && i < mazzo.length : mazzo[i]!=null
        mazzo.shuffle();
        boolean accepted = true;
        accepted = super.getInitialCards(g1, accepted);
        accepted = super.getInitialCards(g2, accepted);
        if( ! accepted) {
            System.err.println("Il GiocatoreBriscola ha rifiutato la carta");
            return null;
        }
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
            Card next = mazzo.pop();
            if(next!=null)
                secondoDiMano.giveCard(next);
            else {
                mazzoIsEmpty = true;
                secondoDiMano.giveCard(briscola);
            }
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
        g1.dropAllCards(3, 40);
        g2.dropAllCards(3, 40);
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

    private GiocatoreBriscola giocaMano(GiocatoreBriscola primoDiMano, GiocatoreBriscola secondoDiMano) {
        CarteATerra c = new CarteATerra(2);
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
