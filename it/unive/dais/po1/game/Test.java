package it.unive.dais.po1.game;

import it.unive.dais.po1.game.giocatori.Giocatore;
import it.unive.dais.po1.game.giocatori.avanzati.GiocatoreIntelligente;
import it.unive.dais.po1.game.giocatori.GiocatoreNaive;
import it.unive.dais.po1.game.gioco.Briscola;
import it.unive.dais.po1.game.gioco.BriscolaADue;
import it.unive.dais.po1.game.gioco.BriscolaAQuattro;
import it.unive.dais.po1.game.gioco.Torneo;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Giocatore[] partecipanti = new Giocatore[5];
        partecipanti[0] = new GiocatoreNaive("Pietro Ferrara");
        partecipanti[1] = new GiocatoreIntelligente("Gianluca Caiazza");
        partecipanti[2] = new GiocatoreNaive("Marcello Pelillo");
        partecipanti[3] = new GiocatoreIntelligente("Alessandra Raffaeta'");
        partecipanti[4] = new GiocatoreIntelligente("Simonetta Balsamo");
        //Torneo t = new Torneo(partecipanti);
        //t.giocaTorneoBriscola();

        BriscolaAQuattro b1 = new BriscolaAQuattro(partecipanti[0], partecipanti[1], partecipanti[2], partecipanti[3]);

        Briscola b = new Random().nextBoolean() ?
                    new BriscolaADue(partecipanti[0], partecipanti[1]) :
                    new BriscolaAQuattro(partecipanti[0], partecipanti[1], partecipanti[2], partecipanti[3]);
        b.partita();
        BriscolaADue b2 = new BriscolaADue(partecipanti[0], partecipanti[1]);
        b2.prende(1, 2);
    }

    public static void longBattle() {
        int partite_per_vincere = 150;
        Giocatore g1 = new GiocatoreIntelligente("Pietro Ferrara");
        //g1 e' un nuovo oggetto
        Giocatore g2 = new GiocatoreNaive("Gianluca Caiazza");


        int vinte_g1 = 0, vinte_g2=0;

        while(vinte_g1!=partite_per_vincere && vinte_g2!=partite_per_vincere) {
            //g1 nuovo oggetto, g2 e' un nuovissimo oggetto
            BriscolaADue partita = new BriscolaADue(g1, g2);
            //g1 nuovo oggetto, g2 e' un nuovissimo oggetto ->
            // g1!=null && g2!=null && g1!=g2?
            Giocatore vincitore = partita.partita();
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
