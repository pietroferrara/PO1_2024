package it.unive.dais.po1.game.carte;

import it.unive.dais.po1.game.carte.trevigiane.FiguraTrevigiana;

import java.util.Objects;

/**
 * Una carta del gioco
 */
public class Card<S extends Seme, F extends Figura> implements Cloneable {
    private final S seme; //1: Denari, 2: Bastoni, 3: Spade, 4: Coppe
    private final F figura; //1: Asso, 2-7: 2-7, 8: Fante, 9: Cavallo, 10: Re

    /**
     * Una carta
     * @param seme seme della carta
     * @param figura figura della carta
     */
    public Card(S seme, F figura) {
        this.seme = seme;
        this.figura = figura;
    }

    public Card() {
        this.seme = null;
        this.figura = null;
    }

    public S getSeme() {
        return seme;
    }


    /**
     * Controlla se la carta e' corretta
     * @return true se la carta e' errata
     */
    public boolean isErrata() {
        return this.figura.isErrata();
    }

    /**
     * Controlla se il seme della carta corrente e quello della carta
     * passata sono uguali
     * @param second l'altra carta
     * @return true se il seme e' lo stesso
     */
    public boolean stessoSeme(Card second) {
        return this.seme == second.seme;
    }

    /**
     * Il valore della carta
     * @return un valore tra 1 e 10 che rappresenta la figura della carta
     *          (1 per asso, 10 per re)
     */
    public int getValue() {
        return this.figura.getValue();
    }

    public <T> T identity(T parametro, int a, S t, FiguraTrevigiana l) {
        T a1 = parametro;
        return parametro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        boolean result = Objects.equals(seme, card.seme) && Objects.equals(figura, card.figura);
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Card<>(seme, figura);
    }

    @Override
    public int hashCode() {
        /*if(seme==null)
            return 0;
        return seme.hashCode();*/
        return Objects.hash(seme, figura);
    }

    /*@Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Card))
            return false;
        Card c = (Card) obj;
        if(this.seme == null && c.seme!=null)
            return false;
        if(this.figura == null && c.figura!=null)
            return false;
        if(this.seme == null && c.seme==null) {
            if(this.figura==null && c.figura==null)
                return true;
            else return this.figura.equals(c.figura);
        }
        else {...}
        return this.seme.equals(c.seme) && this.figura.equals(c.figura);
    }*/

    @Override
    public String toString() {
        return this.figura+" di "+this.seme;
    }
}
