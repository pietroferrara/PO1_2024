package it.unive.dais.po1.game.carte.trevigiane;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.list.ListaCarte;
import it.unive.dais.po1.game.carte.list.Mazzo;

import java.util.Collections;
import java.util.Arrays;


public class MazzoTrevigiano extends Mazzo<Card<SemeTrevigiano,FiguraTrevigiana>> {
    /**
     * Prepara un insieme di 40 carte diverse ordinate
     *
     */
    //ensures \forall i >= 0 && i < mazzo.length : mazzo[i]!=null
    public MazzoTrevigiano() {
        super(40);
        for(int i = 0; i < 40; i++) {
            int semevalue = i / 10;
            SemeTrevigiano seme = null;
            switch(semevalue) {
                case 0 : seme = SemeTrevigiano.DENARI; break;
                case 1: seme = SemeTrevigiano.BASTONI; break;
                case 2: seme = SemeTrevigiano.SPADE; break;
                case 3: seme = SemeTrevigiano.COPPE; break;
            }
            FiguraTrevigiana figura = null;
            switch(i % 10) {
                case 0: figura = FiguraTrevigiana.ASSO; break;
                case 1: figura = FiguraTrevigiana.DUE; break;
                case 2: figura = FiguraTrevigiana.TRE; break;
                case 3: figura = FiguraTrevigiana.QUATTRO; break;
                case 4: figura = FiguraTrevigiana.CINQUE; break;
                case 5: figura = FiguraTrevigiana.SEI; break;
                case 6: figura = FiguraTrevigiana.SETTE; break;
                case 7: figura = FiguraTrevigiana.FANTE; break;
                case 8: figura = FiguraTrevigiana.CAVALLO; break;
                case 9: figura = FiguraTrevigiana.RE; break;
            }
            Card<SemeTrevigiano, FiguraTrevigiana> carta = new Card<SemeTrevigiano, FiguraTrevigiana>(seme, figura);
            super.addCard(carta);
            SemeTrevigiano a = carta.identity(seme, 12, null, null);
        }
    }

}
