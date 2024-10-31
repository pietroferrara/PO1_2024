package it.unive.dais.po1.game.carte.trevigiane;

import it.unive.dais.po1.game.carte.Seme;

public enum SemeTrevigiano implements Seme<SemeTrevigiano> {
    DENARI("Denari"), BASTONI("Bastoni"), SPADE("Spade"), COPPE("Coppe");

    final String niceName;

    SemeTrevigiano(String s) {
        this.niceName = s;
    }

    void print() {
        System.out.println(this.niceName);
    }


    public int compareTo(Seme o) {
        return this.toString().compareTo(o.toString());
    }

}