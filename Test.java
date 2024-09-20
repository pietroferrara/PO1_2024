public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World");
        /*int i = 10;
        int j = 15;
        //int z = somma(i, j);
        int k = i*j/(i*18);
        System.out.println(k);*/
    }


    private int doppiasomma(int i, int j, int z) {
        return somma(i, somma(j, z));
    }

    private int somma(int i, int j) {
        int z = i + j;
        int k = 0;
        return z;
    }

    private int abs(int i) {
        if(i < 0)
            return -i;
        else return i;
    }
}
