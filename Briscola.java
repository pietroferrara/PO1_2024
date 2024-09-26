public class Briscola {

    static Seme semeBriscola;// = new Seme(1);

    static {
        semeBriscola = new Seme(1);
    }


    static boolean maggiore(Card first, Card second) {
        if(first.isErrata() || second.isErrata()) {
            System.err.println("Carta errata");
            return false;
        }

        if(first.seme!=second.seme && second.seme.value != semeBriscola.value)
            return true;
        if(first.seme.value == semeBriscola.value && second.seme.value != semeBriscola.value)
            return true;
        if(first.seme.value !=semeBriscola.value && second.seme.value == semeBriscola.value)
            return false;
        if(maggiore(first.figura.value, second.figura.value))
            return true;
        else return false;
    }

    static private boolean maggiore(int valore, int valore1) {
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
