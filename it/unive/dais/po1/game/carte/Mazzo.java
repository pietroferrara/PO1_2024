package it.unive.dais.po1.game.carte;

import java.util.Collections;
import java.util.Arrays;


public class Mazzo {
    //@invariant mazzo!=null
    private Card[] mazzo;
    //@invariant cartaCorrente>=0 cartaCorrente<mazzo.length
    private int cartaCorrente;

    /**
     * Prepara un insieme di 40 carte diverse ordinate
     *
     */
    //ensures \forall i >= 0 && i < mazzo.length : mazzo[i]!=null
    public Mazzo() {
        mazzo = new Card[40];//ensures mazzo!=null
        //mazzo.length == 40
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
        //mazzo.length == 40
        cartaCorrente = 39;//cartaCorrente>=0
        //cartaCorrente<mazzo.length?
    }

    //@requires <che il mazzo sia pieno>
    //@requires \forall i >= 0 && i < mazzo.length : mazzo[i]!=null
    //@ensures <che ci siano le stesse carte di prima ma forse in posizioni diverse>
    //@ensures \forall i >= 0 && i < pre(mazzo).length :
    //         \exists j >= 0 && j < mazzo.length:
    //                 pre(mazzo[i])==mazzo[j]
    public void shuffle() {
            Collections.shuffle(Arrays.asList(mazzo));
    }

    public Card pop() {
        if(cartaCorrente < 0)
            return null;
        Card result = mazzo[cartaCorrente];
        cartaCorrente--;
        return result;
    }
}
