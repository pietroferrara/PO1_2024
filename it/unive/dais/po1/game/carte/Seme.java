package it.unive.dais.po1.game.carte;

enum Seme {
    DENARI("Denari"), BASTONI("Bastoni"), SPADE("Spade"), COPPE("Coppe");

    final String niceName;

    Seme(String s) {
        this.niceName = s;
    }

    void print() {
        System.out.println(this.niceName);
    }
}