import java.util.Collections;
import java.util.Arrays;


public class Mazzo {
    Card[] mazzo;
    Mazzo() {
        mazzo = new Card[40];
        for(int i = 0; i < 40; i++) {
            int semevalue = i / 10;
            Seme seme = null;
            switch(semevalue) {
                case 0 : seme = Seme.DENARI; break;
                case 1: seme = Seme.BASTONI; break;
                case 2: seme = Seme.SPADE; break;
                case 3: seme = Seme.COPPE; break;
            }
            Figura figura = null;
            switch(i % 10) {
                case 0: figura = Figura.ASSO; break;
                case 1: figura = Figura.DUE; break;
                case 2: figura = Figura.TRE; break;
                case 3: figura = Figura.QUATTRO; break;
                case 4: figura = Figura.CINQUE; break;
                case 5: figura = Figura.SEI; break;
                case 6: figura = Figura.SETTE; break;
                case 7: figura = Figura.FANTE; break;
                case 8: figura = Figura.CAVALLO; break;
                case 9: figura = Figura.RE; break;
            }
            mazzo[i] = new Card(seme, figura);
        }
    }
    
    void shuffle() {
            Collections.shuffle(Arrays.asList(mazzo));
    }
}
