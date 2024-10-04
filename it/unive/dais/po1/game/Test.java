package it.unive.dais.po1.game;

import it.unive.dais.po1.game.giocatori.Giocatore;
import it.unive.dais.po1.game.gioco.Briscola;

public class Test {
    public static void main(String[] args) {
        Giocatore g1 = new Giocatore();
        //g1 e' un nuovo oggetto
        Giocatore g2 = new Giocatore();
        //g1 nuovo oggetto, g2 e' un nuovissimo oggetto
        Briscola partita = new Briscola();
        //g1 nuovo oggetto, g2 e' un nuovissimo oggetto ->
        // g1!=null && g2!=null && g1!=g2?
        Giocatore vincitore = partita.partita(g1, g2);
        // return==g1 || return==g2 || return==null
        if(vincitore ==null) {
            //return==null
            System.out.println("Patta");
        }
        else if(vincitore==g1) {
            //return==g1
            System.out.println("Ha vinto il primo giocatore");
        }
        else
            // return==g2
            System.out.println("Ha vinto il secondo giocatore");


    }

}
