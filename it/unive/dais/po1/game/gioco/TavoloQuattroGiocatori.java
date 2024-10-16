package it.unive.dais.po1.game.gioco;

import it.unive.dais.po1.game.giocatori.Giocatore;


class TavoloQuattroGiocatori {
    private Giocatore[] giocatori = new Giocatore[4];

    TavoloQuattroGiocatori(Giocatore g1, Giocatore g2, Giocatore g3, Giocatore g4) {
        giocatori[0] = g1;
        giocatori[1] = g2;
        giocatori[2] = g3;
        giocatori[3] = g4;
    }

    public void setPrimoDiMano(int i) {
        Giocatore[] newOrder = new Giocatore[4];
        for(int j = 0; j<4; j++) {
            if(j-i>=0)
                newOrder[j-i] = giocatori[j];
            else newOrder[4+j-i] = giocatori[j];
        }
        this.giocatori = newOrder;
    }

    public Giocatore get(int i) {
        return giocatori[i];
    }
}
