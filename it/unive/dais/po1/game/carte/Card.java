package it.unive.dais.po1.game.carte;

public class Card {
    private final Seme seme; //1: Denari, 2: Bastoni, 3: Spade, 4: Coppe
    private final Figura figura; //1: Asso, 2-7: 2-7, 8: Fante, 9: Cavallo, 10: Re

    public Card(Seme seme, Figura figura) {
        this.seme = seme;
        this.figura = figura;
    }

    public void print() {
        this.seme.print();
        this.figura.print();
    }


    public boolean isErrata() {
        return this.figura.isErrata();
    }

    public boolean stessoSeme(Card second) {
        return this.seme == second.seme;
    }

    public int getValue() {
        return this.figura.value;
    }

    void setValue(int value) {
        if(value>0 && value <= 10)
            this.figura.value = value;
    }


}
