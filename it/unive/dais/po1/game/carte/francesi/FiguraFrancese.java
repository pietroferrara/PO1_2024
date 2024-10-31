package it.unive.dais.po1.game.carte.francesi;

import it.unive.dais.po1.game.carte.Figura;

public enum FiguraFrancese implements Figura<FiguraFrancese> {
    ASSO(1), DUE(2), TRE(3), QUATTRO(4), CINQUE(5), SEI(6), SETTE(7), OTTO(8), NOVE(9), DIECI(10), JACK(11), REGINA(12), RE(13);

    public int value; //1: Asso, 2-7: 2-7, 8: Fante, 9: Cavallo, 10: Re

    FiguraFrancese(int i) {
        if(i >= 1 && i <= 13)
            this.value = i;
        else
            this.value = -1;
    }

    void print() {
        if(this.value ==1) System.out.println("Asso");
        if(this.value >= 2 && this.value <= 10) System.out.println(value);
        if(this.value ==11) System.out.println("Jack");
        if(this.value ==12) System.out.println("Regina");
        if(this.value ==13) System.out.println("Re");
        if(this.value == -1) System.out.println("CARTA ERRATA");
    }

    @Override
    public int getValue() {
        return this.value;
    }

    public boolean isErrata() {
        return this.value == -1;
    }
}
