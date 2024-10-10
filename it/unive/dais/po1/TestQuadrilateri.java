package it.unive.dais.po1;

import it.unive.dais.po1.quadrilateri.Quadrato;
import it.unive.dais.po1.quadrilateri.Quadrilatero;

public class TestQuadrilateri {
    public static void main(String[] args) {
        Quadrilatero q = new Quadrato(2);
        System.out.println(q.getArea());
    }
}
