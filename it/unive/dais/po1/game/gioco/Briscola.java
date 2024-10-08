package it.unive.dais.po1.game.gioco;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.Mazzo;
import it.unive.dais.po1.game.giocatori.avanzati.GiocatoreIntelligente;
import it.unive.dais.po1.game.giocatori.GiocatoreNaive;

public class Briscola {

    private Card briscola;// = new it.dais.unive.po1.carte.carte.Seme(1);

    private Mazzo mazzo;

     public Briscola() {
        mazzo = new Mazzo();
         //@invariant mazzo.mazzo!=null
         //@invariant mazzo.cartaCorrente>=0 mazzo.cartaCorrente<mazzo.mazzo.length
     }

    /**
     * Gioca una partita di briscola
     *
     * @param g1 Il primo giocatore diverso da null
     * @param g2 Il secondo giocatore, diverso dal primo e da null
     * @return Il giocatore che ha vinto la partita, oppure null se la partita finisce pari
     */


    /**
     * @requires g1!=null && g2!=null && g1!=g2 //precondizione
     * @ensures return==g1 || return==g2 || return==null
     */
    public GiocatoreIntelligente partitaIntelligente(GiocatoreIntelligente g1, GiocatoreIntelligente g2) {
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
        GiocatoreIntelligente primoDiMano = g1;
        GiocatoreIntelligente secondoDiMano = g2;
        boolean mazzoIsEmpty = false;
        while(! mazzoIsEmpty) {
            GiocatoreIntelligente vincitore = giocaManoIntelligente(primoDiMano, secondoDiMano);
            if(vincitore == secondoDiMano) {
                GiocatoreIntelligente temp = primoDiMano;
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
            GiocatoreIntelligente vincitore = giocaManoIntelligente(primoDiMano, secondoDiMano);
            if(vincitore == secondoDiMano) {
                GiocatoreIntelligente temp = primoDiMano;
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

    private GiocatoreIntelligente giocaManoIntelligente(GiocatoreIntelligente primoDiMano, GiocatoreIntelligente secondoDiMano) {
        Card prima = primoDiMano.getCard(null, this);
        Card seconda = secondoDiMano.getCard(prima, this);
        if(maggiore(prima, seconda)) {
            primoDiMano.takeCards(prima, seconda);
            return primoDiMano;
        }
        else {
            secondoDiMano.takeCards(prima, seconda);
            return secondoDiMano;
        }

    }


    /**
     * @requires g1!=null && g2!=null && g1!=g2 //precondizione
     * @ensures return==g1 || return==g2 || return==null
     */
     public GiocatoreNaive partita(GiocatoreNaive g1, GiocatoreNaive g2) {
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
         GiocatoreNaive primoDiMano = g1;
         GiocatoreNaive secondoDiMano = g2;
         boolean mazzoIsEmpty = false;
         while(! mazzoIsEmpty) {
             GiocatoreNaive vincitore = giocaMano(primoDiMano, secondoDiMano);
             if(vincitore == secondoDiMano) {
                 GiocatoreNaive temp = primoDiMano;
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
             GiocatoreNaive vincitore = giocaMano(primoDiMano, secondoDiMano);
             if(vincitore == secondoDiMano) {
                 GiocatoreNaive temp = primoDiMano;
                 primoDiMano = secondoDiMano;
                 secondoDiMano = temp;
             }
         }
         int punteggiog1 = contaPunti(g1.getCarteVinte());
         int punteggiog2 = contaPunti(g2.getCarteVinte());
         if(punteggiog1 > punteggiog2)
             return g1;
         else if(punteggiog1 < punteggiog2)
             return g2;
         else return null;
         //return g1||g2||null
     }

    private GiocatoreNaive giocaMano(GiocatoreNaive primoDiMano, GiocatoreNaive secondoDiMano) {
        Card prima = primoDiMano.getCard(null, this);
        Card seconda = secondoDiMano.getCard(prima, this);
        if(maggiore(prima, seconda)) {
            primoDiMano.takeCards(prima, seconda);
            return primoDiMano;
        }
        else {
            secondoDiMano.takeCards(prima, seconda);
            return secondoDiMano;
        }

    }

    public boolean maggiore(Card first, Card second) {
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

    public int contaPunti(Card[] m) {
        int puntiTotali = 0;
        for(int i = 0; i < 40; i++) {
            if(m[i] != null) {
                switch (m[i].getValue()) {
                    case 1:
                        puntiTotali += 11;
                        break;
                    case 3:
                        puntiTotali += 10;
                        break;
                    case 10:
                        puntiTotali += 4;
                        break;
                    case 9:
                        puntiTotali += 3;
                        break;
                    case 8:
                        puntiTotali += 2;
                        break;
                    default:
                }
            }
        }
        return puntiTotali;
    }

}
