public class Card {
    int seme; //1: Denari, 2: Bastoni, 3: Spade, 4: Coppe
    int valore; //1: Asso, 2-7: 2-7, 8: Fante, 9: Cavallo, 10: Re

    void print() {
        printSeme();
        printValore();
    }

    void printValore() {
        if(valore==1) System.out.println("Asso");
        if(valore >= 2 && valore <= 7) System.out.println(valore);
        if(valore==8) System.out.println("Fante");
        if(valore==9) System.out.println("Cavallo");
        if(valore==10) System.out.println("Re");
    }

    void printSeme() {
        if(seme==1) System.out.println("Denari");
        if(seme==2) System.out.println("Bastoni");
        if(seme==3) System.out.println("Spade");
        if(seme==4) System.out.println("Coppe");
    }

    boolean maggioreOUguale(Card c, int semeBriscola) {
        if(this.seme!=c.seme && c.seme!= semeBriscola)
            return true;
        if(this.seme == semeBriscola && c.seme!= semeBriscola)
            return true;
        if(this.seme!=semeBriscola && c.seme== semeBriscola)
            return false;
        if(maggiore(this.valore, c.valore))
            return true;
        else return false;
    }

    private boolean maggiore(int valore, int valore1) {
        //assumo valore!=valore1
        if(valore==1)
            return true;
        if(valore==3) {
            if (valore1 == 1)
                return false;
            else return true;
        }
        if(valore1==3)
            return false;
        return valore > valore1;
    }
}
