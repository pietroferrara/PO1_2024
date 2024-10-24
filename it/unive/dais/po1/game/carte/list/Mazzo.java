package it.unive.dais.po1.game.carte.list;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.Figura;
import it.unive.dais.po1.game.carte.Seme;
import it.unive.dais.po1.game.carte.francesi.FiguraFrancese;
import it.unive.dais.po1.game.carte.francesi.SemeFrancese;

import java.util.Arrays;
import java.util.Collections;

public abstract class Mazzo<C extends Card> extends ListaCarte<C> {

    protected Mazzo(int length) {
        super(length);
    }

    //@requires <che il mazzo sia pieno>
    //@requires \forall i >= 0 && i < mazzo.length : mazzo[i]!=null
    //@ensures <che ci siano le stesse carte di prima ma forse in posizioni diverse>
    //@ensures \forall i >= 0 && i < pre(mazzo).length :
    //         \exists j >= 0 && j < mazzo.length:
    //                 pre(mazzo[i])==mazzo[j]
    public void shuffle() {
        Collections.shuffle(Arrays.asList(super.carte));
    }

    public C pop() {
        return super.getFirstCard();
    }
}
