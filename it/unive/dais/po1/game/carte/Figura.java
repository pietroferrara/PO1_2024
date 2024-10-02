package it.unive.dais.po1.game.carte;

/*<default>/package*/ enum Figura {
    ASSO(1), DUE(2), TRE(3), QUATTRO(4), CINQUE(5), SEI(6), SETTE(7), FANTE(8), CAVALLO(9), RE(10);

    int value; //1: Asso, 2-7: 2-7, 8: Fante, 9: Cavallo, 10: Re

    Figura(int i) {
        if(i >= 1 && i <= 10)
            this.value = i;
        else
            this.value = -1;
    }

    void print() {
        if(this.value ==1) System.out.println("Asso");
        if(this.value >= 2 && this.value <= 7) System.out.println(value);
        if(this.value ==8) System.out.println("Fante");
        if(this.value ==9) System.out.println("Cavallo");
        if(this.value ==10) System.out.println("Re");
        if(this.value == -1) System.out.println("CARTA ERRATA");
    }

    public boolean isErrata() {
        return this.value == -1;
    }
}
