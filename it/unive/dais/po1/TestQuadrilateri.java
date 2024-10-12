package it.unive.dais.po1;

import it.unive.dais.po1.quadrilateri.Quadrato;
import it.unive.dais.po1.quadrilateri.Quadrilatero;
import it.unive.dais.po1.quadrilateri.Rectangle;

import java.util.Random;

public class TestQuadrilateri {
    public static void main(String[] args) {
        Quadrilatero q = new Random().nextBoolean() ?
                new Quadrato(2) :
                new Rectangle(10, 5);
        System.out.println(q.getArea());
    }
}
