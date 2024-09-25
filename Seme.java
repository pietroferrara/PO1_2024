public class Seme {
    final int value; //1: Denari, 2: Bastoni, 3: Spade, 4: Coppe

    public Seme(int i) {
        if(i>=1 && i <= 4)
            this.value = i;
        else this.value = -1;
    }


    void print() {
        if(this.value ==1) System.out.println("Denari");
        if(this.value ==2) System.out.println("Bastoni");
        if(this.value ==3) System.out.println("Spade");
        if(this.value ==4) System.out.println("Coppe");
        if(this.value == -1) System.out.println("CARTA ERRATA");
    }

    public boolean isErrato() {
        return this.value==-1;
    }
}
