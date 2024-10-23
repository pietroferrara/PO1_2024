package it.unive.dais.po1.game.carte;

import it.unive.dais.po1.game.carte.trevigiane.FiguraTrevigiana;

/**
 * Una carta del gioco
 */
public class Card<S extends Seme, F extends Figura> {
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
}
