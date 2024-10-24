package it.unive.dais.po1.game.gioco.briscola;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.list.CarteATerra;
import it.unive.dais.po1.game.giocatori.briscola.GiocatoreBriscola;
import it.unive.dais.po1.game.gioco.TavoloQuattroGiocatori;

public class BriscolaAQuattro extends Briscola {
    private GiocatoreBriscola g1, g2, g3, g4;

    public BriscolaAQuattro(GiocatoreBriscola g1, GiocatoreBriscola g2, GiocatoreBriscola g3, GiocatoreBriscola g4) {
        this.g1 = g1;
        this.g2 = g2;
        this.g3 = g3;
        this.g4 = g4;
    }

    public GiocatoreBriscola getLastPlayer() {
        return g4;
    }

    public GiocatoreBriscola partita() {
        TavoloQuattroGiocatori tavolo = new TavoloQuattroGiocatori(g1, g2, g3, g4);
        mazzo.shuffle();
        boolean accepted = true;
        accepted = accepted && getInitialCards(g1, accepted);
        accepted = accepted && getInitialCards(g2, accepted);
        accepted = accepted && getInitialCards(g3, accepted);
        accepted = accepted && getInitialCards(g4, accepted);
        if( ! accepted) {
            System.err.println("Il GiocatoreBriscola ha rifiutato la carta");
            return null;
        }
        briscola = mazzo.pop();
        boolean mazzoIsEmpty = false;
        while(! mazzoIsEmpty) {
            GiocatoreBriscola vincitore = giocaMano(tavolo);
            tavolo.get(0).giveCard(mazzo.pop());
            tavolo.get(1).giveCard(mazzo.pop());
            tavolo.get(2).giveCard(mazzo.pop());
            Card next = mazzo.pop();
            if(next!=null)
                tavolo.get(3).giveCard(next);
            else {
                mazzoIsEmpty = true;
                tavolo.get(3).giveCard(briscola);
            }
        }
        for(int i = 0; i < 3; i++)
            giocaMano(tavolo);
        int punteggiog1 = contaPunti(g1.getCarteVinte()) + contaPunti(g3.getCarteVinte());
        int punteggiog2 = contaPunti(g2.getCarteVinte()) + contaPunti(g4.getCarteVinte());
        g1.dropAllCards(3, 40);
        g2.dropAllCards(3, 40);
        g3.dropAllCards(3, 40);
        g4.dropAllCards(3, 40);
        if(punteggiog1 > punteggiog2) {
            System.out.println("Ha vinto la squadra 1");
            return g1;
        }
        else if(punteggiog1 < punteggiog2) {
            System.out.println("Ha vinto la squadra 2");
            return g2;
        }
        else {
            System.out.println("Patta");
            return null;
        }
    }

    private GiocatoreBriscola giocaMano(TavoloQuattroGiocatori tavolo) {
        GiocatoreBriscola primoDiMano = tavolo.get(0);
        GiocatoreBriscola secondoDiMano = tavolo.get(1);
        GiocatoreBriscola terzoDiMano = tavolo.get(2);
        GiocatoreBriscola quartoDiMano = tavolo.get(3);

        CarteATerra c = new CarteATerra(4);
        Card prima = primoDiMano.getCard(c, this);
        add(c, prima);
        Card seconda = secondoDiMano.getCard(c, this);
        add(c, seconda);
        Card terza = terzoDiMano.getCard(c, this);
        add(c, terza);
        Card quarta = quartoDiMano.getCard(c, this);
        add(c, quarta);
        if(maggiore(prima, seconda) && maggiore(prima, quarta)) {
            primoDiMano.takeCards(c);
            if(prende(terza, prima))
                tavolo.setPrimoDiMano(2);
            //else
            //    tavolo.setPrimoDiMano(0);
            return primoDiMano;
        }
        else if(prende(seconda, prima) && maggiore(seconda, terza)){
            secondoDiMano.takeCards(c);
            tavolo.setPrimoDiMano(1);
            return secondoDiMano;
        }
        else if( (  (prende(terza, seconda) && prende(seconda,prima)) || prende(terza, prima))
                && maggiore(terza, quarta)){
            terzoDiMano.takeCards(c);
            tavolo.setPrimoDiMano(2);
            return terzoDiMano;
        }
        else {
            quartoDiMano.takeCards(c);
            tavolo.setPrimoDiMano(3);
            return quartoDiMano;
        }
    }



}
