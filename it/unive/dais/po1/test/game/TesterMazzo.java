package it.unive.dais.po1.test.game;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.carte.list.MissingCardException;
import it.unive.dais.po1.game.carte.trevigiane.FiguraTrevigiana;
import it.unive.dais.po1.game.carte.trevigiane.MazzoTrevigiano;
import it.unive.dais.po1.game.carte.trevigiane.SemeTrevigiano;
import org.junit.Test;

public class TesterMazzo {


    @Test
    public void test1() throws MissingCardException {
        MazzoTrevigiano m = new MazzoTrevigiano();
        int i = 0;
        while(! m.isEmpty()) {
            Card<SemeTrevigiano, FiguraTrevigiana> card = m.pop();
            i++;
        }
        assert i==40;
    }
}
