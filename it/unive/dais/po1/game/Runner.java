package it.unive.dais.po1.game;

import it.unive.dais.po1.game.carte.list.MissingCardException;
import it.unive.dais.po1.game.giocatori.briscola.GiocatoreBriscola;
import it.unive.dais.po1.game.giocatori.briscola.avanzati.GiocatoreBriscolaIntelligente;
import it.unive.dais.po1.game.giocatori.briscola.GiocatoreBriscolaNaive;
import it.unive.dais.po1.game.gioco.briscola.BriscolaADue;

public class Runner {

    public static void main(String[] args) {


        try {
            //apro risorsa 1
            foo();
        }
        catch(StackOverflowError e) {
            System.err.print("Too many method invocations");
            e.printStackTrace();
        }
        finally {
            System.out.println("Chiudo la risorsa 1");
        }


        /*CarteInMano<Card<SemeTrevigiano, Figura>> inmano = new CarteInMano<>();
        //inmano.add(new Card<>(SemeTrevigiano.BASTONI, FiguraTrevigiana.ASSO));
        Card nextCard = null;
        while(nextCard == null) {
            try {
                nextCard = inmano.getCard();
            } catch (MissingCardException e) {
                System.err.println("Ti sei dimenticato una carta?");
                inmano.add(new Card<>(SemeTrevigiano.BASTONI, FiguraTrevigiana.ASSO));
            }
        }*/

        /*MazzoTrevigiano m = new MazzoTrevigiano();
        Set<Card<SemeTrevigiano,FiguraTrevigiana>> s = m.getSet();
        System.out.println(s);

        /*GiocatoreBriscola[] partecipanti = new GiocatoreBriscola[5];
        partecipanti[0] = new GiocatoreBriscolaNaive("Pietro Ferrara");
        partecipanti[1] = new GiocatoreBriscolaIntelligente("Gianluca Caiazza");
        partecipanti[2] = new GiocatoreBriscolaNaive("Marcello Pelillo");
        partecipanti[3] = new GiocatoreBriscolaIntelligente("Alessandra Raffaeta'");
        partecipanti[4] = new GiocatoreBriscolaIntelligente("Simonetta Balsamo");
        //Torneo t = new Torneo(partecipanti);
        //t.giocaTorneoBriscola();

        BriscolaADue b2 = new BriscolaADue(partecipanti[0], partecipanti[1]);
        b2.partita();*/
    }

    private static void foo() {
        throw new NullPointerException();
    }

    public static void longBattle() throws MissingCardException {
        int partite_per_vincere = 150;
        GiocatoreBriscola g1 = new GiocatoreBriscolaIntelligente("Pietro Ferrara");
        //g1 e' un nuovo oggetto
        GiocatoreBriscola g2 = new GiocatoreBriscolaNaive("Gianluca Caiazza");


        int vinte_g1 = 0, vinte_g2=0;

        while(vinte_g1!=partite_per_vincere && vinte_g2!=partite_per_vincere) {
            //g1 nuovo oggetto, g2 e' un nuovissimo oggetto
            BriscolaADue partita = new BriscolaADue(g1, g2);
            //g1 nuovo oggetto, g2 e' un nuovissimo oggetto ->
            // g1!=null && g2!=null && g1!=g2?
            GiocatoreBriscola vincitore = partita.partita();
            // return==g1 || return==g2 || return==null
            if (vincitore == null) {
                //return==null
                System.out.println("Patta");
            } else if (vincitore == g1) {
                //return==g1
                System.out.println("Ha vinto " + g1.getName());
                vinte_g1++;
            } else {
                // return==g2
                System.out.println("Ha vinto " + g2.getName());
                vinte_g2++;
            }
        }

        if(vinte_g1==partite_per_vincere) {
            System.out.println("Il vincitore finale e' "+g1.getName());
        }
        else if(vinte_g2==partite_per_vincere) {
            System.out.println("Il vincitore finale e' "+g2.getName());
        }
        else System.err.println("This should not be possible");
    }

}
