public class Briscola {

    Seme semeBriscola;// = new Seme(1);

    Mazzo mazzo;

     Briscola() {
        mazzo = new Mazzo();
     }

     Giocatore partita(Giocatore g1, Giocatore g2) {
         mazzo.shuffle();
         boolean accepted = true;
         accepted = accepted && g1.giveCard(mazzo.pop());
         accepted = accepted &&g1.giveCard(mazzo.pop());
         accepted = accepted &&g1.giveCard(mazzo.pop());
         accepted = accepted &&g2.giveCard(mazzo.pop());
         accepted = accepted &&g2.giveCard(mazzo.pop());
         accepted = accepted &&g2.giveCard(mazzo.pop());
         if( ! accepted) {
             System.err.println("Il giocatore ha rifiutato la carta");
             return null;
         }
         Card briscola = mazzo.pop();
         semeBriscola = briscola.seme;
         Giocatore primoDiMano = g1;
         Giocatore secondoDiMano = g2;
         boolean mazzoIsEmpty = false;
         while(! mazzoIsEmpty) {
             Giocatore vincitore = giocaMano(primoDiMano, secondoDiMano);
             if(vincitore == secondoDiMano) {
                 Giocatore temp = primoDiMano;
                 primoDiMano = secondoDiMano;
                 secondoDiMano = temp;
             }
             primoDiMano.giveCard(mazzo.pop());
             Card next = mazzo.pop();
             if(next!=null)
                 secondoDiMano.giveCard(next);
             else {
                 mazzoIsEmpty = true;
                 secondoDiMano.giveCard(briscola);
             }
         }
         for(int i = 0; i < 3; i++) {
             Giocatore vincitore = giocaMano(primoDiMano, secondoDiMano);
             if(vincitore == secondoDiMano) {
                 Giocatore temp = primoDiMano;
                 primoDiMano = secondoDiMano;
                 secondoDiMano = temp;
             }
         }
         int punteggiog1 = g1.contaPunti();
         int punteggiog2 = g2.contaPunti();
         if(punteggiog1 > punteggiog2)
             return g1;
         else if(punteggiog1 < punteggiog2)
             return g2;
         else return null;

     }

    private Giocatore giocaMano(Giocatore primoDiMano, Giocatore secondoDiMano) {
        Card prima = primoDiMano.getCard();
        Card seconda = secondoDiMano.getCard();
        if(maggiore(prima, seconda)) {
            primoDiMano.takeCards(prima, seconda);
            return primoDiMano;
        }
        else {
            secondoDiMano.takeCards(prima, seconda);
            return secondoDiMano;
        }

    }

    boolean maggiore(Card first, Card second) {
        if(first.isErrata() || second.isErrata()) {
            System.err.println("Carta errata");
            return false;
        }

        if(first.seme!=second.seme && second.seme != semeBriscola)
            return true;
        if(first.seme == semeBriscola && second.seme != semeBriscola)
            return true;
        if(first.seme !=semeBriscola && second.seme == semeBriscola)
            return false;
        if(maggiore(first.figura, second.figura))
            return true;
        else return false;
    }

    static private boolean maggiore(Figura f1, Figura f2) {
        //assumo valore!=valore1
        switch(f1) {
            case Figura.ASSO : return true;
            case Figura.TRE:
                switch(f2) {
                    case Figura.ASSO: return false;
                    default: return true;
                }
            default: switch(f2) {
                case Figura.ASSO: return false;
                case Figura.TRE: return false;
                default: return f1.value > f2.value;
            }
        }
    }
}
