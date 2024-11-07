package it.unive.dais.po1.game.carte.list;

import it.unive.dais.po1.game.carte.Card;

import java.util.*;

public abstract class Mazzo<C extends Card> extends ListaCarte<C> {

    protected Mazzo() {
        super();
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

    public C pop() throws MissingCardException {
        return super.getFirstCard();
    }

    @Override
    public String toString() {
        return "Ci sono "+this.contaCarte()+" carte\n";
    }

    private int contaCarte() {
        return this.carte.size();
    }

    public SortedSet<C> getSet() {
        SortedSet<C> set = new TreeSet<C>();
        for(int i = 0; i < carte.size(); i++) {
            set.add(carte.get(i));
        }
        return set;
    }

    public boolean isEmpty() {
        return this.carte.isEmpty();
    }
}
