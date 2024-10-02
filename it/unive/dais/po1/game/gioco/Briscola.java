package it.unive.dais.po1.game.gioco;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.giocatori.Giocatore;

public class Briscola {

    private Card briscola;// = new it.dais.unive.po1.carte.carte.Seme(1);

    private Mazzo mazzo;

     public Briscola() {
        mazzo = new Mazzo();
     }

     public Giocatore partita(Giocatore g1, Giocatore g2) {
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
         int punteggiog1 = g1.contaPunti();
         int punteggiog2 = g2.contaPunti();
         if(punteggiog1 > punteggiog2)
             return g1;
         else if(punteggiog1 < punteggiog2)
             return g2;
         else return null;

     }

    private Giocatore giocaMano(Giocatore primoDiMano, Giocatore secondoDiMano) {
        Card prima = primoDiMano.getCard();
        Card seconda = secondoDiMano.getCard();
        if(maggiore(prima, seconda)) {
            primoDiMano.takeCards(prima, seconda);
            return primoDiMano;
        }
        else {
            secondoDiMano.takeCards(prima, seconda);
            return secondoDiMano;
        }

    }

    boolean maggiore(Card first, Card second) {
        if(first.isErrata() || second.isErrata()) {
            System.err.println("Carta errata");
            return false;
        }

        if(! first.stessoSeme(second) && ! second.stessoSeme(briscola))
            return true;
        if(first.stessoSeme(briscola) && ! second.stessoSeme(briscola))
            return true;
        if(! first.stessoSeme(briscola) && second.stessoSeme(briscola))
            return false;
        if(maggiore(first.getValue(), second.getValue()))
            return true;
        else return false;
    }

    static private boolean maggiore(int f1, int f2) {
        //assumo valore!=valore1
        switch(f1) {
            case 1 : return true;
            case 3:
                switch(f2) {
                    case 1: return false;
                    default: return true;
                }
            default: switch(f2) {
                case 1: return false;
                case 3: return false;
                default: return f1 > f2;
            }
        }
    }
}
