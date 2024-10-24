package it.unive.dais.po1.game.gioco;

import it.unive.dais.po1.game.giocatori.briscola.GiocatoreBriscola;


public class TavoloQuattroGiocatori {
    private GiocatoreBriscola[] giocatori = new GiocatoreBriscola[4];

    public TavoloQuattroGiocatori(GiocatoreBriscola g1, GiocatoreBriscola g2, GiocatoreBriscola g3, GiocatoreBriscola g4) {
        giocatori[0] = g1;
        giocatori[1] = g2;
        giocatori[2] = g3;
        giocatori[3] = g4;
    }

    public void setPrimoDiMano(int i) {
        GiocatoreBriscola[] newOrder = new GiocatoreBriscola[4];
        for(int j = 0; j<4; j++) {
            if(j-i>=0)
                newOrder[j-i] = giocatori[j];
            else newOrder[4+j-i] = giocatori[j];
        }
        this.giocatori = newOrder;
    }

    public GiocatoreBriscola get(int i) {
        return giocatori[i];
    }
}
