package it.unive.dais.po1.game.gioco;

import it.unive.dais.po1.game.giocatori.Giocatore;

public class Torneo {

    private final Giocatore[] partecipanti;


    public Torneo(Giocatore[] partecipanti) {
        this.partecipanti = partecipanti;
    }

    public void giocaTorneoBriscola() {
        int[] punti = new int[partecipanti.length];
        for (int i = 0; i < partecipanti.length; i++) {
            for(int j=0; j< partecipanti.length; j++) {
                if(i!=j) {
                    Giocatore vincitore = new BriscolaADue().partita(partecipanti[i], partecipanti[j]);
                    if(vincitore!=null)
                        System.out.println("Ha vinto "+vincitore.getName());
                    else System.out.println("Patta tra "+partecipanti[i].getName()+" e "+partecipanti[j].getName());
                    if(vincitore == null) {
                        punti[i] = punti[i] + 1;
                        punti[j] = punti[j] + 1;
                    }
                    else if(vincitore==partecipanti[i]) {
                        punti[i] = punti[i] + 3;
                    }
                    else {
                        punti[j] = punti[j] + 3;
                    }
                }
            }
        }
        System.out.println("Classifica \n -------------------- \n");
        for(int i = 0; i < partecipanti.length; i++) {
            System.out.println(partecipanti[i].getName()+" "+punti[i]);
        }
    }
}
