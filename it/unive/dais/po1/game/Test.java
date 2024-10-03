package it.unive.dais.po1.game;

import it.unive.dais.po1.game.giocatori.Giocatore;
import it.unive.dais.po1.game.gioco.Briscola;

public class Test {
    public static void main(String[] args) {
        /* TIPI VALORE
        int i = 10;
        int j = i;
        j = 18;
        double d = 10.23;
        char c = 'a';
        boolean b = true;*/
        Giocatore g1 = new Giocatore();
        Giocatore g2 = new Giocatore();
        Briscola partita = new Briscola();
        Giocatore vincitore = partita.partita(g1, g2);
        if(vincitore ==null) {
            System.out.println("Patta");
        }
        else if(vincitore==g1) {
            System.out.println("Ha vinto il primo giocatore");
        }
        else
            System.out.println("Ha vinto il secondo giocatore");


    }

}
