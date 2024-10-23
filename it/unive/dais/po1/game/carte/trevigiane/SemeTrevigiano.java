package it.unive.dais.po1.game.carte.trevigiane;

import it.unive.dais.po1.game.carte.Seme;

public enum SemeTrevigiano implements Seme {
    DENARI("Denari"), BASTONI("Bastoni"), SPADE("Spade"), COPPE("Coppe");

    final String niceName;

    SemeTrevigiano(String s) {
        this.niceName = s;
    }

    void print() {
        System.out.println(this.niceName);
    }
}