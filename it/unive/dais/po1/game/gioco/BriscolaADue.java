package it.unive.dais.po1.game.gioco;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.CarteATerra;
import it.unive.dais.po1.game.giocatori.Giocatore;

public class BriscolaADue extends Briscola {


    /**
     * @requires g1!=null && g2!=null && g1!=g2 //precondizione
     * @ensures return==g1 || return==g2 || return==null
     */
    public Giocatore partita(Giocatore g1, Giocatore g2) {
        //controllare che g1!=null && g2!=null && g1!=g2
        //@invariant mazzo.mazzo!=null
        //@invariant mazzo.cartaCorrente>=0 mazzo.cartaCorrente<mazzo.mazzo.length
        //@requires \forall i >= 0 && i < mazzo.length : mazzo[i]!=null
        mazzo.shuffle();
        boolean accepted = true;
        accepted = accepted && g1.giveCard(mazzo.pop());
        accepted = accepted &&g1.giveCard(mazzo.pop());
        accepted = accepted &&g1.giveCard(mazzo.pop());
        accepted = accepted &&g2.giveCard(mazzo.pop());
        accepted = accepted &&g2.giveCard(mazzo.pop());
        accepted = accepted &&g2.giveCard(mazzo.pop());
        if( ! accepted) {
            System.err.println("Il giocatore ha rifiutato la carta");
            return null;
        }
        briscola = mazzo.pop();
        Giocatore primoDiMano = g1;
        Giocatore secondoDiMano = g2;
        boolean mazzoIsEmpty = false;
        while(! mazzoIsEmpty) {
            Giocatore vincitore = giocaMano(primoDiMano, secondoDiMano);
            if(vincitore == secondoDiMano) {
                Giocatore temp = primoDiMano;
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
            Giocatore vincitore = giocaMano(primoDiMano, secondoDiMano);
            if(vincitore == secondoDiMano) {
                Giocatore temp = primoDiMano;
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

    private Giocatore giocaMano(Giocatore primoDiMano, Giocatore secondoDiMano) {
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
