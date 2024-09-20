public class Test {
    public static void main(String[] args) {
        Card c1 = new Card();
        c1.seme = 1;
        c1.valore = 8;
        c1.print();

        Card c2 = new Card();
        c2.seme = 2;
        c2.valore = 1;
        c2.print();

        Card c3 = new Card();
        c3.seme = 1;
        c3.valore = 3;
        c3.print();

        System.out.println(c3.maggiore(c1, 2));
        System.out.println(c1.maggiore(c3, 2));
        System.out.println(c2.maggiore(c1, 2));

        c1.seme = 4;

        c1.print();
    }

}
