public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Seme s = new Seme(1);

        Card c1 = new Card(s, new Figura(8));
        c1.print();

        Card c2 = new Card(new Seme(2), new Figura(7));
        c2.print();

        Card c3 = new Card(new Seme(1), new Figura(3));
        c3.print();

        Briscola br = new Briscola();

        System.out.println(Briscola.maggiore(c3, c1));

        Briscola.semeBriscola =  new Seme(2);
        System.out.println(Briscola.maggiore(c3, c1));
        System.out.println(Briscola.maggiore(c1, c3));
        System.out.println(Briscola.maggiore(c2, c1));

        Card c4 = new Card(new Seme(18), new Figura(1));
        c4.print();

        Briscola.semeBriscola =  new Seme(1);
        System.out.println(Briscola.maggiore(c1, c4));

    }

}
