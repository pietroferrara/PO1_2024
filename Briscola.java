public class Briscola {

    static Seme semeBriscola;// = new Seme(1);

    static {
        semeBriscola = Seme.DENARI;
    }


    static boolean maggiore(Card first, Card second) {
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
