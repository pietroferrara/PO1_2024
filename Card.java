public class Card {
    final Seme seme; //1: Denari, 2: Bastoni, 3: Spade, 4: Coppe
    final Figura figura; //1: Asso, 2-7: 2-7, 8: Fante, 9: Cavallo, 10: Re

    public Card(Seme seme, Figura figura) {
        this.seme = seme;
        this.figura = figura;
    }

    void print() {
        this.seme.print();
        this.figura.print();
    }


    public boolean isErrata() {
        return this.figura.isErrata();
    }
}
