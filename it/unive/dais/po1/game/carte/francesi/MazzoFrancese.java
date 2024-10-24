package it.unive.dais.po1.game.carte.francesi;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.list.ListaCarte;
import it.unive.dais.po1.game.carte.list.Mazzo;
import it.unive.dais.po1.game.carte.trevigiane.FiguraTrevigiana;
import it.unive.dais.po1.game.carte.trevigiane.SemeTrevigiano;

import java.util.Arrays;
import java.util.Collections;


public class MazzoFrancese extends Mazzo<Card<SemeFrancese,FiguraFrancese>> {
    /**
     * Prepara un insieme di 40 carte diverse ordinate
     *
     */
    //ensures \forall i >= 0 && i < mazzo.length : mazzo[i]!=null
    public MazzoFrancese() {
        super(40);
        for(int i = 0; i < 40; i++) {
            int semevalue = i / 10;
            SemeFrancese seme = null;
            switch(semevalue) {
                case 0 : seme = SemeFrancese.CUORI; break;
                case 1: seme = SemeFrancese.FIORI; break;
                case 2: seme = SemeFrancese.PICCHE; break;
                case 3: seme = SemeFrancese.QUADRI; break;
            }
            FiguraFrancese figura = null;
            switch(i % 10) {
                case 0: figura = FiguraFrancese.ASSO; break;
                case 1: figura = FiguraFrancese.DUE; break;
                case 2: figura = FiguraFrancese.TRE; break;
                case 3: figura = FiguraFrancese.QUATTRO; break;
                case 4: figura = FiguraFrancese.CINQUE; break;
                case 5: figura = FiguraFrancese.SEI; break;
                case 6: figura = FiguraFrancese.SETTE; break;
                case 7: figura = FiguraFrancese.OTTO; break;
                case 8: figura = FiguraFrancese.NOVE; break;
                case 9: figura = FiguraFrancese.DIECI; break;
                case 10: figura = FiguraFrancese.JACK; break;
                case 11: figura = FiguraFrancese.REGINA; break;
                case 12: figura = FiguraFrancese.RE; break;
            }
            Card<SemeFrancese, FiguraFrancese> carta = new Card<SemeFrancese, FiguraFrancese>(seme, figura);
            super.addCard(carta);
        }
    }
}
