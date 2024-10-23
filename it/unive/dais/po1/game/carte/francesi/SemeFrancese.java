package it.unive.dais.po1.game.carte.francesi;

import it.unive.dais.po1.game.carte.Seme;

public enum SemeFrancese implements Seme {
    PICCHE("Picche"), CUORI("Cuori"), QUADRI("Quadri"), FIORI("Fiori");

    final String niceName;

    SemeFrancese(String s) {
        this.niceName = s;
    }

    void print() {
        System.out.println(this.niceName);
    }
}