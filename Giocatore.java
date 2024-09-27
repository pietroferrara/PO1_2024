public class Giocatore {
    Card[] carte = new Card[3];
    Card[] carteVinte = new Card[40];


    public boolean giveCard(Card pop) {
        if(carte[0] == null) {
            carte[0] = pop;
            return true;
        }
        else if(carte[1] == null) {
            carte[1] = pop;
            return true;
        }
        else if(carte[2] == null) {
            carte[2] = pop;
            return true;
        }
        else return false;
    }

    public Card getCard() {
        for(int i = 0; i < 3; i++) {
            if(carte[i] != null) {
                Card result = carte[i];
                carte[i] = null;
                return result;
            }
        }
        return null;
    }

    public void takeCards(Card prima, Card seconda) {
        int i = 0;
        while(carteVinte[i] != null)
            i++;
        carteVinte[i++] = prima;
        carteVinte[i] = seconda;
    }

    public int contaPunti() {
        int puntiTotali = 0;
        for(int i = 0; i < 40; i++) {
            if(carteVinte[i] != null) {
                switch (carteVinte[i].figura) {
                    case Figura.ASSO:
                        puntiTotali += 11;
                        break;
                    case Figura.TRE:
                        puntiTotali += 10;
                        break;
                    case Figura.RE:
                        puntiTotali += 4;
                        break;
                    case Figura.CAVALLO:
                        puntiTotali += 3;
                        break;
                    case Figura.FANTE:
                        puntiTotali += 2;
                        break;
                    default:
                }
            }
        }
        return puntiTotali;
    }
}
