package Game;


import GameElement.*;
import GameElement.characters.Wizard;
import Level.*;


public class Game {
    private Wizard wizard;

    public static void main(String[] args) throws InterruptedException {
//         initialisation
        Wizard wizard = new Wizard(null, null, null, null);

//        Wizard wizard = new Wizard("mini", Pet.Owl, new Wand(Core.DragonHeartstring, 23), House.GRYFFINDOR);

        AbstractLevel[] levels = new AbstractLevel[]{
                new Level0(),
                new Level1(),
                new Level2(),
                new Level3(),
                new Level4(),
                new Level5(),
                new Level6(),
                new Level7()
        };

        for (AbstractLevel level : levels) {
            level.startLevel(wizard);
            if (!wizard.isAlive()) break;
        }
    }

}