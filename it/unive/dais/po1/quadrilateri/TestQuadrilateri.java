package it.unive.dais.po1.quadrilateri;

import java.util.Random;

public class TestQuadrilateri {
    public static void main(String[] args) {
        Quadrilatero q = new Random().nextBoolean() ?
                new Quadrato(2) :
                new Rectangle(10, 5);
        Rectangle[] rects = new Rectangle[10];
        Quadrilatero[] quads = rects;
        quads[0] = new Quadrato(2);
        quads[1] = new Rectangle(10, 5);
        rects[0] = new Rectangle(10, 5);

    }
}
