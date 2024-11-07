package it.unive.dais.po1.game.gioco.briscola;

import it.unive.dais.po1.game.carte.*;
import it.unive.dais.po1.game.carte.list.Addable;
import it.unive.dais.po1.game.carte.list.AvailableSpots;
import it.unive.dais.po1.game.carte.list.CarteRaccolte;
import it.unive.dais.po1.game.carte.list.MissingCardException;
import it.unive.dais.po1.game.carte.trevigiane.FiguraTrevigiana;
import it.unive.dais.po1.game.carte.trevigiane.MazzoTrevigiano;
import it.unive.dais.po1.game.carte.trevigiane.SemeTrevigiano;
import it.unive.dais.po1.game.giocatori.briscola.GiocatoreBriscola;

abstract public class Briscola {

    protected Card<SemeTrevigiano, FiguraTrevigiana> briscola;// = new it.dais.unive.po1.carte.carte.Seme(1);

    protected MazzoTrevigiano mazzo;

     public Briscola() {
        mazzo = new MazzoTrevigiano();
         //@invariant mazzo.mazzo!=null
         //@invariant mazzo.cartaCorrente>=0 mazzo.cartaCorrente<mazzo.mazzo.length
     }


     abstract public GiocatoreBriscola partita() throws MissingCardException;

     public boolean prende(Card first, Card second) {
         if(first.isErrata() || second.isErrata()) {
             System.err.println("Carta errata");
             return false;
         }
         if(first.stessoSeme(briscola) && ! second.stessoSeme(briscola))
             return true;
         if(first.stessoSeme(second))
             return maggiore(first.getValue(), second.getValue());
         else return false;
     }

    public boolean maggiore(Card first, Card second) {
        if(first.isErrata() || second.isErrata()) {
            System.err.println("Carta errata");
            return false;
        }

        if(first.stessoSeme(briscola) && ! second.stessoSeme(briscola))
            return true;
        if(! first.stessoSeme(briscola) && second.stessoSeme(briscola))
            return false;
        if(! first.stessoSeme(second) && ! second.stessoSeme(briscola))
            return true;
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

    public static int contaPunti(CarteRaccolte m) {
        int puntiTotali = 0;
        for(int i = 0; i < m.size(); i++) {
            Card c = m.get(i);
            if(c != null) {
                switch (c.getValue()) {
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

    protected void getInitialCards(GiocatoreBriscola g1) throws MissingCardException {
        g1.giveCard(mazzo.pop());
        g1.giveCard(mazzo.pop());
        g1.giveCard(mazzo.pop());
    }


    protected static boolean add(Addable l, Card c) {
         if(l instanceof AvailableSpots){//controllo del tipo dinamico
             //qui so che l e' un AvailableSpots
             AvailableSpots l1 = (AvailableSpots) l;//cast del tipo
            if (l1.acceptMoreItems() == false)
                return false;
        }

        if(c==null) {
            System.err.println("Trying to add a null card to a ListaCarte");
            return false;
        }
        else { l.add(c); return true; }
    }


}
