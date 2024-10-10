package it.unive.dais.po1.game;

import it.unive.dais.po1.game.giocatori.Giocatore;
import it.unive.dais.po1.game.giocatori.avanzati.GiocatoreIntelligente;
import it.unive.dais.po1.game.giocatori.GiocatoreNaive;
import it.unive.dais.po1.game.gioco.Briscola;

public class Test {
    public static void mainNaive(String[] args) {

        GiocatoreNaive g1 = new GiocatoreNaive("Pietro Ferrara");
        //g1 e' un nuovo oggetto
        GiocatoreNaive g2 = new GiocatoreNaive("Gianluca Caiazza");

        //g1 nuovo oggetto, g2 e' un nuovissimo oggetto
        Briscola partita = new Briscola();
        //g1 nuovo oggetto, g2 e' un nuovissimo oggetto ->
        // g1!=null && g2!=null && g1!=g2?
        GiocatoreNaive vincitore = partita.partita(g1, g2);
        // return==g1 || return==g2 || return==null
        if(vincitore ==null) {
            //return==null
            System.out.println("Patta");
        }
        else if(vincitore==g1) {
            //return==g1
            System.out.println("Ha vinto "+g1.getName());
        }
        else
            // return==g2
            System.out.println("Ha vinto "+g2.getName());
    }


    public static void main(String[] args) {
        int partite_per_vincere = 150;
        GiocatoreIntelligente g1 = new GiocatoreIntelligente("Pietro Ferrara");
        //g1 e' un nuovo oggetto
        GiocatoreIntelligente g2 = new GiocatoreIntelligente("Gianluca Caiazza");


        int vinte_g1 = 0, vinte_g2=0;

        while(vinte_g1!=partite_per_vincere && vinte_g2!=partite_per_vincere) {
            //g1 nuovo oggetto, g2 e' un nuovissimo oggetto
            Briscola partita = new Briscola();
            //g1 nuovo oggetto, g2 e' un nuovissimo oggetto ->
            // g1!=null && g2!=null && g1!=g2?
            GiocatoreIntelligente vincitore = partita.partitaIntelligente(g1, g2);
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
