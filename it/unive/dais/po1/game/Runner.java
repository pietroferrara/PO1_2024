package it.unive.dais.po1.game;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.francesi.MazzoFrancese;
import it.unive.dais.po1.game.carte.list.MissingCardException;
import it.unive.dais.po1.game.carte.trevigiane.MazzoTrevigiano;
import it.unive.dais.po1.game.giocatori.briscola.GiocatoreBriscola;
import it.unive.dais.po1.game.giocatori.briscola.avanzati.GiocatoreBriscolaIntelligente;
import it.unive.dais.po1.game.giocatori.briscola.GiocatoreBriscolaNaive;
import it.unive.dais.po1.game.gioco.briscola.BriscolaADue;
import it.unive.dais.po1.reflection.A;

import java.lang.reflect.*;

public class Runner {

    public static void main(String[] args) throws MissingCardException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Class c1 = new A().getClass();

        A a = new A();
        for(Method m : c1.getDeclaredMethods()) {
            m.setAccessible(true);
            System.out.println(m.getName());
            m.invoke(new A());
        }
    }


}
