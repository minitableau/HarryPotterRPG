package Game;


import GameElement.*;
import Level.Level0;
import Level.Level1;
import Level.Level2;


public class Game {
    private Wizard wizard;

    public static void main(String[] args) throws InterruptedException {
        // initialisation
        Wizard wizard = new Wizard(null, null, null, null);

//        Wizard wizard = new Wizard("mini", Pet.Owl, new Wand(Core.DragonHeartstring, 23), House.GRYFFINDOR);
        new Level0().level0(wizard);
        Level1.level1(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
        Level2.level2(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
    }

}